package src.operation;

import java.util.Stack;

import src.mua.Main;
import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class ExportOp extends Operation {

	public ExportOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if(paras.size() < 1)
//			// TODO raise exception for wrong number of parameters
//			return;
		
		MuaValue name = paras.pop();
		
		// judge the type
		if(!(name instanceof MuaWord)) {
			// TODO Name must be a word
		} 
		
		if(!namespace.existName((MuaWord)name)) {
			//TODO variable doesn't exist, baojingle
		}
		
		MuaValue value = namespace.getValue((MuaWord)name);
		Main.globalNameSpace.createName((MuaWord)name, value);
		return;
	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
