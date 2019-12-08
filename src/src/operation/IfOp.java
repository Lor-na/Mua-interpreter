package src.operation;

import java.util.ArrayList;
import java.util.List;
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
		
		// clone the paraList
		List<String> tempParaList = new ArrayList<>();
		for(int i = 0; i < Parser.paraList.size(); i++)
			tempParaList.add(Parser.paraList.get(i));
		Parser.paraList.clear();
		
		// insert "if" sentence
		String[] elements = inst.split("\\s+");
		if(!inst.isEmpty()) {
			for(int j = elements.length - 1; j >= 0; j--) Parser.paraList.add(0, elements[j]);
		}
		
		// execute if
		while(!Parser.paraList.isEmpty())
			Parser.parse(namespace);
		
		// give back paraList
		for(int i = 0; i < tempParaList.size(); i++)
			Parser.paraList.add(tempParaList.get(i));
		
		return;
	}

	@Override
	public int getParaNum() {
		return 3;
	}

}
