package consume;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "Group 1");
		prop.put(ConsumerConfig.CLIENT_ID_CONFIG, "Consumer");
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		
		KafkaConsumer<String,String> consumer = new KafkaConsumer<>(prop);
		ConsumerRecords<String,String> records ;
		
		consumer.subscribe(Arrays.asList("lab3"));
		try {
			while(true) {
				records = consumer.poll(Duration.ofMillis(1000));
				System.out.println("Got " + records.count() + " messages");
				for (ConsumerRecord<String,String> record : records ) {
					System.out.println("Message: " + record);
				}
					
			}
		}
		finally {
			consumer.close();
		}
		
		
		
		

	}

}