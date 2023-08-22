package pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

	public static void main(String[] args) {

		// Creates a new Thread Pool with 3 executors
		
		ExecutorService myPool = Executors.newFixedThreadPool(1);
		for (int i = 1; i < 10; i++) {
			myPool.execute(new MyTask("Task " + i));
		}
		// Shuts the pool down once all the threads have terminated
		myPool.shutdown();

	}
}
