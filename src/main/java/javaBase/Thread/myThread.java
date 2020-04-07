package javaBase.Thread;

public class myThread extends Thread {
	yue  read;
	String name="";
	public myThread() {
		
	}
	public myThread(yue read,String name) {
		this.read=read;
		this.name=name;
	}
	@Override
	public void run() {
			//read.show(name);
	}
	
}
