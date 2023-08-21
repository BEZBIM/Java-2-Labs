package prod;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {

	public static void main(String[] args) {
		
		// Create properties object
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.serializer", StringSerializer.class.getName());
		prop.setProperty("value.serializer", StringSerializer.class.getName());
		
		
		// Create the producer
		
		final KafkaProducer<String,String> p = new KafkaProducer<String,String>(prop);
		
		// Create the ProducerRecord
		for (int i = 1 ; i <=10; i++) {
		 ProducerRecord<String,String> record = new ProducerRecord<>("lab1","value "+i);
		
		// Send data
		p.send(record);
		System.out.println("Sent message " + i);
		}
		// flush and close the producer
		p.flush();
		p.close();
		

	}

}

