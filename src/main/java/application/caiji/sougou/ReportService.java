package application.caiji.sougou;

import java.util.Map;

public class ReportService {
	private ReportService() {}
	private static StringBuilder mathodElements = new StringBuilder();
	//获取下载报表地址
	public static String getReportAddrss(Map<String,String> elementData) throws Exception{
		mathodElements.append("<v11:getReportIdRequest>\r\n")
		.append("<reportRequestType>\r\n");
		for(Map.Entry<String, String> entry:elementData.entrySet()) {
			mathodElements.append("<")
			.append(entry.getKey())
			.append(">")
			.append(entry.getValue())
			.append("</")
			.append(entry.getKey())
			.append(">\r\n");
		}
		mathodElements.append("</reportRequestType>\r\n")
		.append("</v11:getReportIdRequest>\r\n");
		String url = "http://api.agent.sogou.com/sem/sms/v1/ReportService";
		//获取reportId
		String reportId = GetReportId.getData(mathodElements.toString(), url,"reportId");
		mathodElements.delete(0, mathodElements.length());
		mathodElements.append("<v11:getReportStateRequest>\r\n")
		.append("<reportId>")
		.append(reportId)
		.append("</reportId>\r\n")
		.append("</v11:getReportStateRequest>\r\n");
		//报表下载是否成功
		String isGenerated = GetReportId.getData(mathodElements.toString(), url,"isGenerated");
		System.out.println(isGenerated);
		mathodElements.delete(0, mathodElements.length());
		//获取下载报表地址
		if("1".equals(isGenerated)) {
			mathodElements.append("<v11:getReportPathRequest>\r\n")
			.append("<reportId>")
			.append(reportId)
			.append("</reportId>\r\n")
			.append("</v11:getReportPathRequest>\r\n");
			String reportPath = GetReportId.getData(mathodElements.toString(), url,"reportFilePath");
			mathodElements.delete(0, mathodElements.length());
			return reportPath;
		}
		return null;
	}
}
