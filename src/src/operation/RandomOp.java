package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;

public class RandomOp extends Operation {

	public RandomOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaNumber v = (MuaNumber)paras.pop();
		
		double bound = v.getValue();
		
		double res = Math.random() * bound;
		
		MuaNumber n = new MuaNumber(res);
		
		paras.push(n);

	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
