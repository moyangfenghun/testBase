package newcontent.singleton;

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
