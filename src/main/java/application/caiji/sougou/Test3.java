package application.caiji.sougou;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;


public class Test3 {
	@Test
	public void doTest3() throws Exception{
		Properties pro = SougouProperties.getMap("reportService");
		Map<String,String> elementData = new HashMap<>(pro.size());
		String key = "";
		for(Object object:pro.keySet()) {
			key = object.toString();
			elementData.put(key, pro.getProperty(key));
		}
		String reportAddrss = ReportService.getReportAddrss(elementData);
		System.out.println(reportAddrss);
		pro.clear();
	}
}
