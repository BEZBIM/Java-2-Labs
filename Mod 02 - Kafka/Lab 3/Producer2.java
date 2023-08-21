package prod2;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer2 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.serializer", StringSerializer.class.getName());
		prop.setProperty("value.serializer", StringSerializer.class.getName());
		prop.put("client.id", "Producer2");
		prop.put("acks", "all");
		prop.put("retries", 0);
		prop.put("batch.size", 16384);
		prop.put("buffer.memory", 33554432);
		
		final KafkaProducer<String,String> p = new KafkaProducer<String,String>(prop);
		ProducerRecord<String,String> record;
		
		for (int i = 1 ; i <=10; i++) {
			String key = "Key " + i + ": ";
			 record = new ProducerRecord<>("lab3",key,"Message - "+i);		
			// Send data
			p.send(record);
			System.out.println("Sent record " + i);
			}
			// flush and close the producer
			p.flush();
			p.close();
		

	}

}

