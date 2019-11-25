package javaBase.user;

import javaBase.zhujie.zidingyi;


public class user  {
	public String name="yyy";
	public int age=18;
	public user() {
		
	}
	
	public user(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@zidingyi("自定义的注解")
	public void eat() {
		System.out.println("吃饭");
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "user [name=" + name + ", age=" + age + "]";
	}
	
}
