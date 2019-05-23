package yers.test.Thread;

public class account {
	private int id;
	private int number=0;
	private volatile int age=0;
	public int getId() {
		return id;
	}
	public int getNumber() {
		return number;
	}
	public int getAge() {
		return age;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void addNumber(){
		this.number = number+1;
	}
	public void addAge(){
		this.age=age+1;
	}
	public synchronized void addid(){
		this.id = id+1;
	}
}
