package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class EraseOp extends Operation {

	public EraseOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		
		if (paras.size() != 1) {
			// TODO wrong number of parameter
			return;
		}
		
		MuaValue name = paras.pop();
		
		if(!(name instanceof MuaWord)) {
			// TODO wrong type
		}
		
		namespace.eraseName((MuaWord)name);
	}

}
