# Lab 2-1 Extending the Thread Class
### IBM Intermediate Java

---

## Lab Overview

This lab creates a thread runnable object by extending the `Thread` class. This specific method of creating runnable objects is a construct found in older Java code before constructs like `Executor` interfaces became a more common way of managing runnable objects.

If you are writing new Java code, you should avoid this approach since it is less efficient and requires you to write a lot of boiler plate code. However, if you are working supporting legacy Java installations, you may find this pattern of creating runnable objects in the code.


## Part One: Creating the Task Class

1. The purpose of the `Task` class is to override the `run()` method in the Java `Thread` class.  The `Thread` class has all of the code necessary to create and schedule an object of type `Task` so that you don't have to. For example, the `start()` method in the `Thread` creates the runnable object and schedules it for execution by the thread manager in the JVM

2. The only thing the `Task` class _must_ do is override the `run()` method with the code that should execute as a thread. It can do other things, as the next point illustrates.

3. The `Task` object takes a `String` variable as a name so that we see can tell what thread is running.

4. The `Thread.sleep()` method yields the CPU for a given amount of time but still might have to deal with an `interrupt` thrown as an `InterruptedException` while it is asleep.

5. An `interrupt` is a message sent to a thread that it should stop whatever it is doing and do something else, like stop listening on an input port. 

```java
class Task extends Thread {
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

<br/><br/>

## Part Two: Create the Runner class.

1. Create two `Task` objecta and give them unique names.

2. Send each a `start()` method. Note that this method is defined in the `Thread` class.

```java
public class Runner {

	public static void main(String[] args) {
		Task t1 = new Task("one");
		Task t2 = new Task("two");
		t1.start();
		t2.start();
	}
}
```
3. Since the two objects are running concurrently, their output statements will be interleaved.

```console
Running one 1
Running one 2
Running one 3
Running one 4
Running one 5
Running two 1
Running one 6
Running two 2
Running one 7
Running one 8
Running one 9
Running two 3
Running one 10
Running two 4
Running two 5
Running two 6
Running two 7
Running two 8
Running two 9
Running two 10
```

4. If you run the code several times, notice that the order the statements print out varies. This is called _nondeterminism_ which means that we can't predict when the threads start exactly when each will get to run. This is because other factors like background JVM threads, like the garbage collector, also will take turns using CPU.

<br/><br/>

## Part Three: Running the code as a non-thread

1. The `start()` method sets the `Task` class to run as a thread and automatically calls the `run()` method. If we call the `run()` method directly instead, the code is not run as a thread, but the first `Task` object runs, followed by the second `Task` object.

2. Instead of calling the `start()` method, call the `run()` on both `Task` objects.

```java
	public static void main(String[] args) {
		Task t1 = new Task("one");
		Task t2 = new Task("two");
		//t1.start();
		//t2.start();
		t1.run();
		t2.run();
	}
```
```console
Running one 1
Running one 2
Running one 3
Running one 4
Running one 5
Running one 6
Running one 7
Running one 8
Running one 9
Running one 10
Running two 1
Running two 2
Running two 3
Running two 4
Running two 5
Running two 6
Running two 7
Running two 8
Running two 9
Running two 10
```

<br/><br/>

**Save you work - you will use it in the next lab**

---
## DONE!!



