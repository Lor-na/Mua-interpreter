package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public abstract class OperatorForCal extends Operation {
	
	protected MuaNumber formerOperand;
	protected MuaNumber latterOperand;
	
	public OperatorForCal() {
	}
	
	protected void preCalculate(Stack<MuaValue> paras) {
		if(paras.size() < 2)
			// TODO raise exception for wrong number of parameters
			return;
		
		MuaValue formerPara = paras.pop();
		MuaValue latterPara = paras.pop();
		
		// judge the type
		if(formerPara instanceof MuaNumber) {
			this.formerOperand = (MuaNumber)formerPara;
		} else if(formerPara instanceof MuaWord) {
			this.formerOperand = ((MuaWord)formerPara).getMuaNumber();
		} else {
			// TODO operand must be number
		}
		
		if(latterPara instanceof MuaNumber) {
			this.latterOperand = (MuaNumber)latterPara;
		} else if(latterPara instanceof MuaWord) {
			this.latterOperand = ((MuaWord)latterPara).getMuaNumber();
		} else {
			// TODO operand must be number
		}

	}
	

	@Override
	public abstract void execute(Stack<MuaValue> paras, Namespace namespace);

}
