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
		
		String text = "在货币供应量[002-009-004-000-9787512905580-image/002-009-004-000-9787512905580-011-001.jpg]、[002-009-004-000-9787512905580-image/002-009-004-000-9787512905580-011-002.jpg]、[002-009-004-000-9787512905580-image/002-009-004-000-9787512905580-011-003.jpg]和[002-009-004-000-9787512905580-image/002-009-004-000-9787512905580-011-004.jpg]的层次划分中,流动性最强的是()。";
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
