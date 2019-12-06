package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;

public class NotOp extends OperatorForLogicOne {

	public NotOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		super.preCalculate(paras);
		
		boolean res = !super.operand.getValue();
		
		MuaValue v = new MuaBool(res);
		paras.push(v);

	}
	
	public int getParaNum() {
		return 1;
	}
}
