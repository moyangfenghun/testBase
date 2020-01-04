package newcontent;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class test2 {

	public static void main(String[] args) throws IOException {
		System.out.println("start:"+LocalDateTime.now());
		
		String text = "芝加哥期货交易所的建立及特点。";
		Analyzer analyzer = new IKAnalyzer(true);
		StringReader reader = new StringReader(text);
		TokenStream ts = analyzer.tokenStream("", reader);  
		ts.reset();
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class); 
        while(ts.incrementToken()){  
            System.out.print(term.toString()+"|");  
        }
        analyzer.close();
        reader.close();  
		
		System.out.println("\nend:"+LocalDateTime.now());
	}

}
