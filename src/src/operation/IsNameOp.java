package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;
import src.value.MuaWord;

public class IsNameOp extends Operation {

	public IsNameOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {

		if (paras.size() < 1) {
			// TODO wrong number of parameter
			return;
		}
		
		MuaValue name = paras.pop();
		
		if(!(name instanceof MuaWord)) {
			// TODO wrong type
		}
		
		MuaValue b = new MuaBool(namespace.existName((MuaWord)name));
		paras.push(b);
	}

}
