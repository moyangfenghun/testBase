package cest;

public class son extends Parent implements Cloneable {
	public son() {
		System.out.println("这是儿子");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public void setname(String names) {
		this.name=names;
		System.out.println(name);
	}
}
