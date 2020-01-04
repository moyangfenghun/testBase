package application.caiji.sougou;

import java.util.Map;

import org.junit.Test;

public class GetReportId {
	private static StringBuilder strbGetReportId = new StringBuilder();
	private GetReportId() {}
	public static String getData(String mathodElements,String url,String element) throws Exception {
		strbGetReportId.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n")
		.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://api.sogou.com/sem/common/v1\" xmlns:v11=\"https://api.sogou.com/sem/sms/v1\">\r\n")
		.append("<soapenv:Header>\r\n")
		.append("<v1:AuthHeader>\r\n")
		.append("<v1:username>wenjian@bangkaoedu.com</v1:username>\r\n")
		.append("<v1:password>2019*BKW-sg</v1:password>\r\n")
		.append("<v1:token>3e96c3724dd86d33155d273ff73d4982</v1:token>\r\n")
		.append("</v1:AuthHeader>\r\n")
		.append("</soapenv:Header>\r\n")
		.append("<soapenv:Body>\r\n")
		.append(mathodElements)
		.append("</soapenv:Body>\r\n")
		.append("</soapenv:Envelope>");
		Map<String, String> map = SoapXmlUtil.postSougou(strbGetReportId.toString(), url);
		strbGetReportId.delete(0, strbGetReportId.length());
		return map.get(element);
	}
}
