package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;

public class SubOp extends OperatorForCal {

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {

		super.preCalculate(paras);
		
		double res = super.formerOperand.getValue() - super.latterOperand.getValue();
		System.out.println(super.formerOperand.getValue());
		MuaValue v = new MuaNumber(res);
		paras.push(v);
		
	}

}
