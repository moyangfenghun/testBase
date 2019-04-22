package test.date;

import java.util.Calendar;
import java.util.Date;

public class datetest {

	public static void main(String[] args) {
		timetest timetest = new timetest();
		timetest.date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 12); // 年月日 也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
		Date date = calendar.getTime();// date就是你需要的时间
	}

}
