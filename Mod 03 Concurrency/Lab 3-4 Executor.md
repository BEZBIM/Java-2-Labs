# Lab 3-4 Executor Interface
### IBM Intermediate Java

---

## Lab Overview

The more modern approach is to use an `Executor` interface to delegate off to the JVM the management of creating and running `Thread` objects rather extending a thread class or implementing a `Runnable` interface.
<br/><br/>

## Part One:  Create the Thread class

1. For this lab, create a `pools` package to work in. 

2. For this lab, create a `Runnable` object that prints out information about itself

3. The class implements `Runnable` but also prints out the name of the thread it is running in using a `Thread` static method.

4. We will use the `Thread.sleep()` method to slow down the output so we can see what is happening.

```java
package pools;

class MyTask implements Runnable {

	public String name;

	public MyTask(String n) {
		this.name = n;
	}

	@Override
	public void run() {
		String message = Thread.currentThread().getName() + ": " + this.name;
		System.out.println(message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e);			
		}
	}
}
```
<br/><br/>

## Part Two:  Use a fixed size Executor 

1. Create a fixed size executor pool.

```java
package pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

	public static void main(String[] args) {

		// Creates a new Thread Pool with 3 executors
		
		ExecutorService myPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 5; i++) {
			myPool.execute(new MyTask("Task " + i));
		}
		// Shuts the pool down once all the threads have terminated
		myPool.shutdown();

	}
}
```
2. Run the code and see the results.

3. Experiment with the number of threads in the pool and the number of tasks created.

<br/><br/>

## Part Three:  Use a configurable executor

1. Instead of using a fixed poole executor, modify the `Runner` class to use the configurable executor interface as in the following.

```java
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

```
2. Run the code and notice that the three threads can handle all of the jobs queued up.

3. Experiment with changing the size of the blocking queue to 10 and increasing the number of tasks to 100. Can you explain why the exception is thrown? Hint: look at how many tasks were executed. Change the size of the blocking queue to 30 and see what happens.

4. Experiment with the pool size. Leaving the buffer size at 10, increase the `maxPoolSize` to 50 and see what happens.


---

## DONE!!



