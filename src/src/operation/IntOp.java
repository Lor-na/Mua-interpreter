package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;

public class IntOp extends Operation {

	public IntOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaNumber v = (MuaNumber)paras.pop();
		
		double val = v.getValue();
		
		MuaNumber res = new MuaNumber(Math.floor(val));
		
		paras.push(res);

	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
