package javaBase.Thread;

public class Runthread implements Runnable {
	yue redthread;
	int i;

	public Runthread() {

	}

	public Runthread(yue redthread,int i) {
		super();
		this.i=i;
		this.redthread = redthread;
	}

	@Override
	public void run() {
		synchronized (redthread) {
			redthread.show("s:",i);
		}
		
	}

}
