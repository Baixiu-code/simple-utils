package com.craftsman.util;



import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class JakartaRegex {
	/**
	 * @throws MalformedPatternException 
	 * 
	* @Title: verifiyNum 
	* @Description: 验证数字的正则表达式
	* @author:陈方林
	* @param @param strNum
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean verifiyNum(String strNum) throws MalformedPatternException{
		Pattern pattern = new Perl5Compiler().compile("\\d+");   
	    Perl5Matcher matcher = new Perl5Matcher();  
	    PatternMatcherInput matcherInput = new PatternMatcherInput(strNum);  
	    
	    if(!matcher.contains(matcherInput, pattern)) {  
	    	System.out.println("该输入不是数字，请重新输入！");
	    	return false;
	    }else{
	    	System.out.println("该输入是数字格式！");
	    	return true;
	    }	   
	}
	/**
	 * 
	* @Title: verifiyPhoneNo 
	* @Description: 验证中国手机号
	* @author:陈方林
	* @param @param strPhoneNo
	* @param @return
	* @param @throws MalformedPatternException    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean verifiyPhoneNo(String strPhoneNo) throws MalformedPatternException{
		Pattern pattern = new Perl5Compiler().compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");   
		Perl5Matcher matcher = new Perl5Matcher();  
	    PatternMatcherInput matcherInput = new PatternMatcherInput(strPhoneNo);  
	    
	    if(!matcher.contains(matcherInput, pattern)) {  
	    	System.out.println("该输入不是手机号格式，请重新输入！");
	    	return false;
	    }else{
	    	System.out.println("该输入是手机号格式！");
	    	return true;
	    }	   
	}
	/**
	 * 
	* @Title: verifiyMail 
	* @Description: 验证邮件格式
	* @author:陈方林
	* @param @param strMail
	* @param @return
	* @param @throws MalformedPatternException    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean verifiyMail(String strMail) throws MalformedPatternException{
		Pattern pattern = new Perl5Compiler().compile("(^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$)");    
		Perl5Matcher matcher = new Perl5Matcher();  
	    PatternMatcherInput matcherInput = new PatternMatcherInput(strMail);  
	    
	    if(!matcher.contains(matcherInput, pattern)) {  
	    	System.out.println("该输入不是邮件格式，请重新输入！");
	    	return false;
	    }else{
	    	System.out.println("该输入是邮件格式！");
	    	return true;
	    }	
	}
	public static void main (String args[]) throws MalformedPatternException{
		verifiyNum("1212");
		verifiyNum("测试");
		verifiyPhoneNo("15700990099");
		verifiyMail("chenfanglincfl@163.com");
	}
	
	
}
