package pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner2 {

		public static void main(String[] args) {

			int corePoolSize = 3;
			int maxPoolSize = 5;
			long keepAliveTime = 3000;
			BlockingQueue<Runnable> pool = new ArrayBlockingQueue<Runnable>(100);
			
				
			ExecutorService myPool = new ThreadPoolExecutor(
					corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,pool);
		
			
			for (int i = 1; i < 10; i++) {
				myPool.execute(new MyTask("Task " + i));
			}
			myPool.shutdown();
			


		}

}
