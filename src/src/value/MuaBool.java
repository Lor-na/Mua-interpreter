package src.value;

public class MuaBool extends MuaValue {

	private boolean value;
	
	public MuaBool(String content) {
		if(isType(content)) {
			if(content.equals("true"))
				value = true;
			else
				value = false;
		}else {
			// TODO illegal
		}
	}
	
	public MuaBool(boolean content) {
		value = content;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public static boolean isType(String content) {
		if(content.equals("true") || content.equals("false")) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void print() {
		System.out.println(value);
	}
}
