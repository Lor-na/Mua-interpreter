package src.operation;

import java.util.Stack;

import src.mua.Parser;
import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaValue;

public class IfOp extends Operation {

	public IfOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if(paras.size() < 3)
			// TODO raise exception for wrong number of parameters
			return;
		
		MuaValue list2 = paras.pop();
		MuaValue list1 = paras.pop();
		MuaBool condition = (MuaBool)paras.pop();
		String inst;
		
		if(condition.getValue()) {
			inst = ((MuaList)list1).getOriginList();
		}
		else {
			inst = ((MuaList)list2).getOriginList();
		}
		
		String[] elements = inst.split("\\s+");
		for(int j = elements.length - 1; j >= 0; j--) Parser.paraList.add(0, elements[j]);
		
		return;
	}

	@Override
	public int getParaNum() {
		return 3;
	}

}
