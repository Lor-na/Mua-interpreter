package src.operation;

import java.util.Stack;

import src.mua.Main;
import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;
import src.value.MuaWord;

public class IsNameOp extends Operation {

	public IsNameOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {

//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue name = paras.pop();
		
		if(!(name instanceof MuaWord)) {
			// TODO wrong type
		}
		
		
		MuaValue b;
		if(namespace.existName((MuaWord)name)) {
			b = new MuaBool(true);
		}else if(Main.globalNameSpace.existName((MuaWord)name)) {
			b = new MuaBool(true);
		}else {
			b = new MuaBool(false);
		}
		
		paras.push(b);
	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
