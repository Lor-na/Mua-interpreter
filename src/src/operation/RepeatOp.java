package src.operation;

import java.util.Stack;

import src.mua.Parser;

import src.name.Namespace;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;

public class RepeatOp extends Operation {

	public RepeatOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if(paras.size() < 2) {
//			// TODO: raise error for wrong number of parameters
//			return;
//		}
		// TODO: not list type parameter
		MuaList l = (MuaList)paras.pop();
		MuaNumber n = (MuaNumber)paras.pop();
		
		String inst = l.getOriginList();
//		System.out.println(inst);
		for(int i = 0; i < n.getValue(); i++) {
			String[] elements = inst.split("\\s+");
			if(!inst.isEmpty())
				for(int j = elements.length - 1; j >= 0; j--) Parser.paraList.add(0, elements[j]);
		}
		
		// execute repeat
		while(!Parser.paraList.isEmpty())
			Parser.parse(namespace);
		
		return;
	}

	@Override
	public int getParaNum() {
		return 2;
	}

}
