package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;

public class OrOp extends OperatorForLogicTwo {

	public OrOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		super.preCalculate(paras);
		
		boolean res = super.formerOperand.getValue() | super.latterOperand.getValue();
		
		MuaValue v = new MuaBool(res);
		paras.push(v);


	}

}
