package asynchronous.threadExamples;

public class ThreadExample {
	public static void main(String[] args) {
		Thread thread  = new Thread(new LoadingBar2());
		Thread thread2 = new Thread(new LoadingBar3());
		
		thread.start();
		thread2.start();
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Name: " + thread2.getName());		
	}	
}

class LoadingBar2 implements Runnable {
	@Override
	public void run() {	
		try {
			Thread.sleep(3000);
			System.out.println("Loaded LoadingBar2");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class LoadingBar3 implements Runnable {	
	@Override
	public void run() {	
		try {
			Thread.sleep(1000);
			System.out.println("Loaded LoadingBar3");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
