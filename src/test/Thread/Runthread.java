package test.Thread;

public class Runthread implements Runnable {
	tedthread redthread;
	int i;

	public Runthread() {

	}

	public Runthread(tedthread redthread,int i) {
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
