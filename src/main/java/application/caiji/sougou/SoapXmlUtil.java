package application.caiji.sougou;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SoapXmlUtil {
	private static Map<String, String> map = new HashMap<String, String>();
	public static Map<String, String> postSougou(String StrXml,String url) throws Exception{
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("text/xml");
		RequestBody body = RequestBody.create(mediaType,StrXml);
		Request request = new Request.Builder()
		  .url(url)
		  .post(body)
		  .addHeader("Content-Type", "text/xml")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "14337ee3-478f-4eed-90ff-0cd47dc3f886")
		  .build();
		Response response = client.newCall(request).execute();
		String soapXml = response.body().string();
		System.out.println(soapXml);
		Document document = DocumentHelper.parseText(soapXml);
		Element elements = document.getRootElement();
		Iterator it = elements.elementIterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			String name = element.getName();
			switch(name) {
				case "Header":
					ParseDom(element.elementIterator());
					break;
				case "Body":
					ParseDom(element.elementIterator());
					break;
			}
		}
		return map;
	}
	// 获取具体key-value
		private static void ParseDom(Iterator iterators) {
			while (iterators.hasNext()) {
				Element element = (Element) iterators.next();
				Iterator iterator = element.elementIterator();
				if (iterator.hasNext()) {
					ParseDom(iterator);
				} else {
					String key = element.getName();
					String value = element.getStringValue();
					map.put(key, value);
				}
			}
		}
}
