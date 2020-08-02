/*    */ package Transformer;
/*    */ 
/*    */ import java.time.Duration;
/*    */ import java.util.Locale;
/*    */ import org.apache.kafka.streams.KeyValue;
/*    */ import org.apache.kafka.streams.kstream.Transformer;
/*    */ import org.apache.kafka.streams.processor.ProcessorContext;
/*    */ import org.apache.kafka.streams.processor.PunctuationType;
/*    */ import org.apache.kafka.streams.state.KeyValueStore;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NotificationTransformer
/*    */   implements Transformer<String, String, KeyValue<String, String>>
/*    */ {
/*    */   private ProcessorContext context;
/*    */   private KeyValueStore<String, Long> kvStore;
/*    */   private KeyValueStore<String, String> wordStore;
/*    */   
/*    */   public void init(ProcessorContext context) {
/* 23 */     this.context = context;
/*    */ 
/*    */     
/* 26 */     this.kvStore = (KeyValueStore<String, Long>)context.getStateStore("Counts");
/* 27 */     this.wordStore = (KeyValueStore<String, String>)context.getStateStore("Words");
/*    */ 
/*    */     
/* 30 */     this.context.schedule(Duration.ofSeconds(1L), PunctuationType.WALL_CLOCK_TIME, timestamp -> {
/*    */           Long value = (Long)this.kvStore.get("vineet");
/*    */           String sendStatus = (String)this.wordStore.get("vineet");
/*    */           if (value.longValue() == 28L) {
/*    */             context.forward("vineet", value.toString());
/*    */             System.out.println(value + "  pre commit " + sendStatus);
/*    */             context.commit();
/*    */             System.out.println(value + "  post commit");
/*    */           } else {
/*    */             System.out.println(value + " hello");
/*    */           } 
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public KeyValue<String, String> transform(String key, String line) {
/* 56 */     String[] words = line.toLowerCase(Locale.getDefault()).split(" ");
/*    */     
/* 58 */     System.out.println("1");
/*    */     
/* 60 */     for (String word : words) {
/* 61 */       Long oldValue = (Long)this.kvStore.get(word);
/*    */       
/* 63 */       if (oldValue == null) {
/* 64 */         this.kvStore.put(word, Long.valueOf(1L));
/*    */       } else {
/* 66 */         this.kvStore.put(word, Long.valueOf(oldValue.longValue() + 1L));
/*    */       } 
/*    */     } 
/*    */     
/* 70 */     return null;
/*    */   }
/*    */   
/*    */   public void close() {}
/*    */ }


/* Location:              C:\Users\Vineet Shukla\Downloads\kafkastreamdemo-ms\target\classes\!\Transformer\NotificationTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */