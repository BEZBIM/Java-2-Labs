# Lab 2-2 Implementing the Runnable Interface
### IBM Intermediate Java

---

## Lab Overview

This lab modifies the previous lab to use the `Runnable` interface rather than inheritance. This is actually a more efficient method since there is not the overhead maintaining an inheritance hierarchy.

All we need to do to create a thread is give the `Thread` class any object that implements the `run()` method. In later labs, we will get away from using object for this.


## Part One: Creating the Task Class

1. The only change we make in the `Task` class is to chance from inheritance to implementation. Notice that we are still overriding the `run()` method in both cases.

```java
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

<br/><br/>

## Part Two: Creating the Runner Class

1. This is basically the decorator pattern again. We have a `Runnable` object and we use dependency injection to wrap it in a `Thread` object. Everything works exactly as before.

```java
public class Runner {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task("one"));
		Thread t2 = new Thread(new Task("two"));
		t1.start();
		t2.start();
	}

}
```
```console
Running one 1
Running one 2
Running two 1
Running two 2
Running one 3
Running two 3
Running one 4
Running one 5
Running two 4
Running two 5
Running two 6
Running two 7
Running two 8
Running two 9
Running one 6
Running one 7
Running one 8
Running one 9
Running one 10
Running two 10

```

---
## DONE!!



