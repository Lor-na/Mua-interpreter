package src.operation;

import java.util.HashMap;
import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;

public abstract class Operation {
	
	private static HashMap<String, Operation> map = new HashMap<>();
	
	static {
		map.put("make", new MakeOp());
		map.put("thing", new ThingOp());
		map.put("erase", new EraseOp());
		map.put("isname", new IsNameOp());
		map.put("print", new PrintOp());
		map.put("read", new ReadOp());
		map.put("add", new AddOp());
		map.put("sub", new SubOp());
		map.put("mul", new MulOp());
		map.put("div", new DivOp());
		map.put("mod", new ModOp());
		map.put("eq", new EqualOp());
		map.put("gt", new GreaterThanOp());
		map.put("lt", new LessThanOp());
		map.put("and", new AndOp());
		map.put("or", new OrOp());
		map.put("not", new NotOp());
		map.put("readlist", new ReadListOp());
		map.put("repeat", new RepeatOp());
		map.put("output", new OutputOp());
		map.put("stop", new StopOp());
		map.put("export", new ExportOp());
		map.put("if", new IfOp());
		map.put("isnumber", new IsNumberOp());
		map.put("isword", new IsWordOp());
		map.put("islist", new IsListOp());
		map.put("isbool", new IsBoolOp());
		map.put("isempty", new IsEmptyOp());
	}
	
	public static Operation getOperation(String opName) {
		Operation res;
		
		if(!checkOp(opName)) {
			// TODO opName doesn't exist
			res = null;
		}
		
		res = map.get(opName);
		return res;
	}
	
	public static boolean checkOp(String content) {
		return map.containsKey(content);
	}
	
	public abstract void execute(Stack<MuaValue> paras, Namespace namespace);
	
	public abstract int getParaNum();
	
}
