/*     */ package Transformer;
/*     */ 
/*     */ import com.avro.account_notify_status.account_notify_status;
/*     */ import com.avro.accountcreate.event.account_create_event;
/*     */ import com.avro.notification.event.notification_event;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.time.Duration;
/*     */ import java.util.Date;
/*     */ import org.apache.kafka.streams.KeyValue;
/*     */ import org.apache.kafka.streams.kstream.Transformer;
/*     */ import org.apache.kafka.streams.processor.ProcessorContext;
/*     */ import org.apache.kafka.streams.processor.PunctuationType;
/*     */ import org.apache.kafka.streams.state.KeyValueIterator;
/*     */ import org.apache.kafka.streams.state.KeyValueStore;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccountNotificationTransformer
/*     */   implements Transformer<String, account_create_event, KeyValue<String, notification_event>>
/*     */ {
/*     */   private ProcessorContext context;
/*     */   private KeyValueStore<String, account_notify_status> account_notify_status_store;
/*     */   
/*     */   public void init(ProcessorContext context) {
/*  30 */     this.context = context;
/*     */ 
/*     */     
/*  33 */     this.account_notify_status_store = (KeyValueStore<String, account_notify_status>)context.getStateStore("account_notify_status_store");
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.context.schedule(Duration.ofSeconds(10L), PunctuationType.WALL_CLOCK_TIME, timestamp -> {
/*     */           System.out.println("timestamp = " + timestamp);
/*     */           this.account_notify_status_store.all();
/*     */           KeyValueIterator<String, account_notify_status> iter = this.account_notify_status_store.all();
/*     */           while (iter.hasNext()) {
/*     */             KeyValue<String, account_notify_status> entry = (KeyValue<String, account_notify_status>)iter.next();
/*     */             if (getDuration(((account_notify_status)entry.value).getAccountCreateTime().toString()) >= Long.parseLong(((account_notify_status)entry.value).getNotifyDays().toString()) && ((account_notify_status)entry.value).getNotifyStatus().toString().equals("NO")) {
/*     */               ((account_notify_status)entry.value).setNotifyStatus("YES");
/*     */               this.account_notify_status_store.put(entry.key, entry.value);
/*     */               notification_event outputEvent = new notification_event();
/*     */               outputEvent.setAccountCreateTime(((account_notify_status)entry.value).getAccountCreateTime());
/*     */               outputEvent.setAccountName(((account_notify_status)entry.value).getAccountName());
/*     */               outputEvent.setNotificationDescription("Account Created for more than 7 days");
/*     */               outputEvent.setNotificationEventName("Account Created Duration Event");
/*     */               outputEvent.setNotificationEventTime((new Date()).toLocaleString());
/*     */               context.forward(entry.key, outputEvent);
/*     */             } 
/*     */           } 
/*     */           iter.close();
/*     */           context.commit();
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyValue<String, notification_event> transform(String key, account_create_event value) {
/*  84 */     account_notify_status newEntry = new account_notify_status();
/*     */     
/*  86 */     newEntry.setAccountCreateTime(value.getAccountCreateTime());
/*  87 */     newEntry.setAccountName(value.getAccountName());
/*  88 */     newEntry.setNotifyDays(value.getNotifyDays());
/*  89 */     newEntry.setNotifyStatus("NO");
/*     */ 
/*     */     
/*  92 */     this.account_notify_status_store.put(value.getAccountName().toString(), newEntry);
/*     */     
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDuration(String accountCreationTime) {
/* 109 */     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     Date accountEventDate = null;
/*     */     try {
/* 116 */       accountEventDate = formatter.parse(accountCreationTime);
/* 117 */     } catch (ParseException e) {
/* 118 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 121 */     Date currentTime = new Date();
/*     */ 
/*     */     
/* 124 */     long durationInMillis = currentTime.getTime() - accountEventDate.getTime();
/*     */     
/* 126 */     long diffInDays = durationInMillis / 86400000L;
/*     */     
/* 128 */     return diffInDays;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vineet Shukla\Downloads\kafkastreamdemo-ms\target\classes\!\Transformer\AccountNotificationTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */