package test2.singleton;

public class threadme  implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(":"+idlerPattern.getIdler()); 
		
	}

}
