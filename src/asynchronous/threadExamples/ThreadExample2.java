package asynchronous.threadExamples;

public class ThreadExample2 {
	public static void main(String[] args) {
		PDFGenerator startPDFGenerator  = new PDFGenerator();
		LoadingBar startLoadingBar = new LoadingBar(startPDFGenerator);
		
		startPDFGenerator.start();
		startLoadingBar.start();		
	}	
}

class PDFGenerator extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Started PDF Generator");
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PDF Generated with Success");
	}
}

class LoadingBar extends Thread {
	private Thread startPDFGenerator;
	
	public LoadingBar(Thread startPDFGenerator) {
		this.startPDFGenerator = startPDFGenerator;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
				if(!startPDFGenerator.isAlive()) {
					break;
				}
				System.out.println("Loading ... ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

