package src.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Util {

	public static String[] operatorEnumRegex = {"\\+", "-", "\\*", "/", "%", "\\(", "\\)"};
	public static String[] operatorEnumOne = {"(", ")"};
	public static String[] operatorEnumTwo = {"*", "/", "%"};
	public static String[] operatorEnumThree = {"+", "-"};
	
	public static String addSpace(String input) {
		for(int i = 0; i < operatorEnumRegex.length; i++) {
			input = input.replaceAll(operatorEnumRegex[i], " " + operatorEnumRegex[i] + " ");
		}
		return input;
	}
	
	public static double doExp(String operator, double operand1, double operand2) {
		if(operator.equals("+")) {
			return operand1 + operand2;
		}
		else if(operator.equals("-")) {
			return operand1 - operand2;
		}else if(operator.equals("*")) {
			return operand1 * operand2;
		}else if(operator.equals("/")) {
			return operand1 / operand2;
		}else if(operator.equals("%")) {
			return operand1 % operand2;
		}else
			// error
			return 0;
	}
	
	public static int isExpOperator(String operator) {
		if(Arrays.asList(operatorEnumOne).contains(operator))
			return 1;
		else if(Arrays.asList(operatorEnumTwo).contains(operator))
			return 2;
		else if(Arrays.asList(operatorEnumThree).contains(operator))
			return 3;
		else 
			return 0;
	}
	
	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isType(Pattern pattern, String content) {
		if (content == null)
			// TODO raise exception for empty content
			return false;
		Matcher matcher = pattern.matcher(content);
		boolean res = matcher.matches();
		return res;
	}

}
