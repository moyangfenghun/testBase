package application.caiji.sougou;

import java.util.Properties;
public class SougouProperties {
	private static Properties pro = new Properties();
	public static Properties getMap(String fileName) throws Exception{
		pro.load(SougouProperties.class.getClassLoader().getResourceAsStream("\\sougou\\"+fileName+".properties"));
		for(Object entry : pro.keySet()) {
			System.out.println(entry.toString()+"="+pro.get(entry.toString()));
		}
		return pro;
	}

}
