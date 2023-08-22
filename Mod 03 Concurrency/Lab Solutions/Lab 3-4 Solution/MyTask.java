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