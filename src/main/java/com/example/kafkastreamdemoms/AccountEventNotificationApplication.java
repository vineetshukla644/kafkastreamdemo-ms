/*    */ package kafkastreamdemoms;
/*    */ 
/*    */ import Transformer.AccountNotificationTransformer;
/*    */ import com.avro.account_notify_status.account_notify_status;
/*    */ import com.avro.accountcreate.event.account_create_event;
/*    */ import com.avro.notification.event.notification_event;
/*    */ import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.function.Function;
/*    */ import org.apache.kafka.common.serialization.Serde;
/*    */ import org.apache.kafka.common.serialization.Serdes;
/*    */ import org.apache.kafka.streams.kstream.KStream;
/*    */ import org.apache.kafka.streams.kstream.Transformer;
/*    */ import org.apache.kafka.streams.state.StoreBuilder;
/*    */ import org.apache.kafka.streams.state.Stores;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.boot.SpringApplication;
/*    */ import org.springframework.boot.autoconfigure.SpringBootApplication;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SpringBootApplication
/*    */ public class AccountEventNotificationApplication
/*    */ {
/*    */   @Value("${spring.cloud.stream.kafka.streams.binder.configuration.schema.registry.url}")
/*    */   private String schemaRegistryURL;
/*    */   
/*    */   public static void main(String[] args) {
/* 31 */     SpringApplication.run(AccountEventNotificationApplication.class, args);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public Function<KStream<String, account_create_event>, KStream<String, notification_event>> process() {
/* 39 */     String[] stores = { "account_notify_status_store" };
/*    */     
/* 41 */     return input -> input.transform((), stores);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public StoreBuilder myStore() {
/* 48 */     return Stores.keyValueStoreBuilder(
/* 49 */         Stores.persistentKeyValueStore("account_notify_status_store"), 
/* 50 */         Serdes.String(), 
/* 51 */         configureAvroSerde());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Serde<account_notify_status> configureAvroSerde() {
/* 60 */     Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url", this.schemaRegistryURL);
/*    */ 
/*    */     
/* 63 */     SpecificAvroSerde specificAvroSerde = new SpecificAvroSerde();
/* 64 */     specificAvroSerde.configure(serdeConfig, false);
/* 65 */     return (Serde<account_notify_status>)specificAvroSerde;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vineet Shukla\Downloads\kafkastreamdemo-ms\target\classes\!\kafkastreamdemoms\AccountEventNotificationApplication.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */