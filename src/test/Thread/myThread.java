package test.Thread;

public class myThread extends Thread {
	tedthread  read;
	String name="";
	public myThread() {
		
	}
	public myThread(tedthread read,String name) {
		this.read=read;
		this.name=name;
	}
	@Override
	public void run() {
			//read.show(name);
	}
	
}
