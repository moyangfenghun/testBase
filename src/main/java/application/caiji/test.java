package application.caiji;

import java.math.BigDecimal;
import java.util.Date;

import application.caiji.unitls.mySqlHelper_local_pool;

public class test {
	public static void main(String[] args) {
		System.out.println("开始"+new Date());
//		String insertsql="insert into test(id,text) values(3,?) ON DUPLICATE KEY UPDATE text=values(text)";
//		String values[]={"null"};
//		mySqlHelper_local_pool.executeUpdate(mySqlHelper_local_pool.Conn_local_mysql__testdate,insertsql,values);
		
		int parseInt = Integer.parseInt("8880820");
		int parseInt2 = Integer.parseInt("4425575");
		int parseInt3 = Integer.parseInt("4425575");

		System.out.println("结束"+new Date());
	}
}
