package test.dynamicProxy;

public class JobSearchImplement implements JobSearch {
	String name;
	public JobSearchImplement() {
		
	}
	@Override
	public String getresumeName() {
		System.out.println("获取名字..");
		return name;
	}

	@Override
	public void displayname() {
		System.out.println("显示名字:"+name);
	}

	@Override
	public void setname(String name) {
		System.out.println("设置名字..");
		this.name=name;
	}
	
	public void A() {
		System.out.println("能不能代理呢？");
	}

}
