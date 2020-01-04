package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaValue;
import src.value.MuaWord;

public class IsEmptyOp extends Operation {

	public IsEmptyOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if(paras.size() < 1) {
//			// TODO: raise error for wrong number of parameters
//			return;
//		}
		MuaValue para = paras.pop();
		
//		System.out.println("Isempty");
//		para.print();
		
		boolean res;
		if(para instanceof MuaList) {
			res = ((MuaList)para).size() == 0;
		} else if(para instanceof MuaWord) {
			res = ((MuaWord)para).getValue().isEmpty();
		}
		else {
			// TODO: error
			res = false;
		}
		MuaBool result = new MuaBool(res);
		
//		System.out.println("Isempty");
//		result.print();
		
		paras.push(result);

	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
