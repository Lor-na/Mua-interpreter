package src.value;

public abstract class MuaValue {

	public MuaValue() {
		// TODO Auto-generated constructor stub
	}
	
	public static MuaValue getValue(String content) {
		// is Number
		if(MuaNumber.isType(content)) {
			return new MuaNumber(content);
		} else if(MuaWord.isType(content)){
			return new MuaWord(content, false);
		} else if(MuaBool.isType(content)) {
			return new MuaBool(content);
		} else {
			// TODO illegal src.value
			return null;
		}
	}
	
	public abstract void print();
	
}
