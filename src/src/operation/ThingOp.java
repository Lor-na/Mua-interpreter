package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class ThingOp extends Operation {

	public ThingOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if(paras.size() < 1)
			// TODO raise exception for wrong number of parameters
			return;
		
		MuaValue name = paras.pop();
		
		if(!(name instanceof MuaWord)) {
			// TODO wrong type
		}
		
		MuaValue result = namespace.getValue((MuaWord)name);
		paras.push(result);
	}

}
