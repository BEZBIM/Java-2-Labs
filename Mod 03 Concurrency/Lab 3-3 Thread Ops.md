# Lab 3-3 Thead Methods
### IBM Intermediate Java

---

## Lab Overview

In this lab, we explore some of the methods provided by the `Thread` class


## Part One:  Creating a Use Thread

1. There are a number of JVM system threads, called _daemon_ threads that run in the background.

2. The `main()` method and any thread we create are called _user_ threads.

3. Create a use thread class that just goes to sleep when it starts up.

```java
class myThread implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```
<br/><br/>

## Part Two: Examining Thread Info

1. The `main()` method creates a user thread, sets the name to `MyThread` and sets the thread priority to `7`.

2. The for loop gets a list of all the threads running and displays information about each one.

```java 
public class Runner {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new myThread());
		t1.setName("MyThread");
		t1.setPriority(7);
		t1.start();
		
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
		for (Thread t : threads) {
		    System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
		}
	}
}
```

![](images/Screenshot_20230821_211744.png?raw=true)

br/><br/>

## Part Three: Exceptions

1. Use the code from Lab 3-2. If you don't have it, the starter code is here:

```java
public class Runner2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task("one"));
		Thread t2 = new Thread(new Task("two"));
		t1.start();
		t2.start();
	}

}

class Task implements Runnable {
	private String name = null;
	
	public Task(String n) {
		this.name = n;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++){
			System.out.println("Running " + this.name + " " + i);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
```
2. Throwing an exception in a thread terminates that thread. However, all of the other threads that are executing will continue until they are finished. This includes the `main()` thread, if it terminates due to an exception, any other threads it spawned will continue.

3. Add the exceptions code as shown.

```java
public class Runner2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task("one"));
		Thread t2 = new Thread(new Task("two"));
		t1.start();
		t2.start();
		// throw new RuntimeException();
	}

}

class Task implements Runnable {
	private String name = null;
	
	public Task(String n) {
		this.name = n;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++){
			System.out.println("Running " + this.name + " " + i);
			// if ((this.name == "one") && (i == 5)) throw new RuntimeException(); 
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}

```

3. Run the code to see how it works without exceptions.

4. Uncomment the exception in the `main()` method and note that the other threads keep on running.

5. Now comment out the exception code in the `run()` method and see what happens. 

---

## DONE!!



