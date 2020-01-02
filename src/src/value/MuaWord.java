package src.value;

import java.util.regex.Pattern;

import src.util.Util;

public class MuaWord extends MuaValue {

	private String value;
	private static final Pattern pattern = Pattern.compile("^\".*");
	
	public MuaWord(String content, boolean isWord) {
		if(isWord) {
			value = content;
		} else {
			if(isType(content)) {
				value = content.substring(1);
			}else {
				// TODO illegal
			}
		}
	}
	
	public String getValue() {
		return value;
	}
	
	public static boolean isType(String content) {
		return Util.isType(pattern, content);
	}
	
	public MuaNumber getMuaNumber() {
		if(!MuaNumber.isType(value)) {
			// TODO can't transfer to src.mua number
		}
		MuaNumber n = new MuaNumber(Double.valueOf(value));
		return n;
	}
	
	public MuaWord attach(String v) {
		String s = value + v;
		MuaWord res = new MuaWord(s, true);
		return res;
	}
	
	public boolean isMuaBool() {
		return MuaBool.isType(value);
	}
	
	public MuaBool getMuaBool() {
		if(!MuaBool.isType(value)) {
			// TODO can't transfer to src.mua bool
		}
		MuaBool b;
		if(value.equals("true")){
			b = new MuaBool(true);
		}else {
			b = new MuaBool(false);
		}
		return b;
	}
	
	public boolean isMuaNumber() {
		return MuaNumber.isType(value);
	}
	
	@Override
	public void print() {
		System.out.println(value);
	}

}
