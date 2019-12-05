package src.value;

import java.util.regex.Pattern;

import src.util.Util;

public class MuaNumber extends MuaValue{

	private double value;
	private static final Pattern pattern = Pattern.compile("^-?[0-9]+(.[0-9]+)?");
	
	public MuaNumber(String content) {

		if(isType(content)) {
			value = Double.valueOf(content);
		}else {
			// TODO if it's not a number
		}
	}
	
	public MuaNumber(double v) {
		value = v;
	}
	
	public double getValue() {
		return this.value;
	}

	public static boolean isType(String content) {
		return Util.isType(pattern, content);
	}
	
	@Override
	public void print() {
		System.out.println(value);
	}

}
