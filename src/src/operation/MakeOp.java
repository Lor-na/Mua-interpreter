package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class MakeOp extends Operation {

	public MakeOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if(paras.size() != 2)
			// TODO raise exception for wrong number of parameters
			return;
		
		MuaValue name = paras.pop();
		MuaValue value = paras.pop();
		
		// judge the type
		if(!(name instanceof MuaWord)) {
			// TODO Name must be a word
		} 
		
		namespace.createName((MuaWord)name, value);
	}

}
