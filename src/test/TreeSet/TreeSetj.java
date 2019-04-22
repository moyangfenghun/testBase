package test.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import test.user.user;

public class TreeSetj {
	@Test
	public void paixu() {// 第一个减去第二个，默认升序
		TreeSet<user> set=new TreeSet<>(new Comparator<user>() {
			public int compare(user o1, user o2) {
				return o1.age-o2.age;
			};
		});
		set.add(new user("yy",11));
		set.add(new user("sy",2));
		set.add(new user("fy",20));
		set.add(new user("ry",20));
		set.add(new user("y",28));
		set.add(new user("ys",12));
		for(user i:set) {
			System.out.println(i.age);
		}
		
	}
}
