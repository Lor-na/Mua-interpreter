package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;

public class IsBoolOp extends Operation {

	public IsBoolOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if(paras.size() < 1) {
			// TODO: raise error for wrong number of parameters
			return;
		}
		MuaValue para = paras.pop();
		boolean res;
		res = para instanceof MuaBool;
		MuaBool result = new MuaBool(res);
		paras.push(result);

	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
