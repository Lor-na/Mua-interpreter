package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;

public class DivOp extends OperatorForCal {

	public DivOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {

		super.preCalculate(paras);
		
		// TODO div 0
		double res = super.formerOperand.getValue() / super.latterOperand.getValue();
		
		MuaValue v = new MuaNumber(res);
		paras.push(v);

	}

}
