package javaBase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class regex {
	@Test
	public void test2() {
		// \斜杠为java转义字符，\\我要插入一个正则表达式的\,\\\=\,4个是双斜杠
		//注：\\.=.  ; .表示任意字符 ;
		String regex="[^\\u4e00-\\u9fa5]",string="1";
		//Regex regex2=new Regex(regex);
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(string);
		System.out.println(matcher.matches());
	}
	
	public void test() {
		 Pattern pattern = Pattern.compile("\\d{3,5}");
	        String charSequence = "123-435-23455-909";
	        Matcher matcher = pattern.matcher(charSequence);
	 
	        //虽然匹配失败，但由于charSequence里面的"123"和pattern是匹配的,所以下次的匹配从位置4开始 
	        /*matches整体匹配是否成功返回boolean,匹配失败或者成功都将移动匹配位置到下一个位置
	         * matches理解为匹配字符串整体是否等于模式，返回boolean值
	        */
	        System.out.println(matcher.matches());
	        //测试匹配位置
	        matcher.find();
	        System.out.println(matcher.start());
	 
	        //使用reset方法重置匹配位置
	        matcher.reset();
	 
	        //第一次find匹配以及匹配的目标和匹配的起始位置
	        /*find部分匹配是否成功返回boolean值,匹配失败或者成功都将移动匹配位置到下一个位置
	         * find理解为匹配字符串中是否包含模式，返回boolean值
	        */
	        System.out.println(matcher.find());
	        System.out.println(matcher.group()+" - "+matcher.start());
	        //第二次find匹配以及匹配的目标和匹配的起始位置
	        System.out.println(matcher.find());
	        System.out.println(matcher.group()+" - "+matcher.start());
	 
	        //第一次lookingAt匹配以及匹配的目标和匹配的起始位置
	        /*
	         * lookingAt部分匹配，同find,但不管是否匹配成功都不移动匹配位置
	         */
	        System.out.println(matcher.lookingAt());
	        System.out.println(matcher.group()+" - "+matcher.start());
	 
	        //第二次lookingAt匹配以及匹配的目标和匹配的起始位置
	        System.out.println(matcher.lookingAt());
	        System.out.println(matcher.group()+" - "+matcher.start());
	}
}
