package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;
import src.value.MuaWord;

public abstract class OperatorForLogicTwo extends Operation {

	protected MuaBool formerOperand;
	protected MuaBool latterOperand;
	
	public OperatorForLogicTwo() {
		// TODO Auto-generated constructor stub
	}
	
	protected void preCalculate(Stack<MuaValue> paras) {
//		if(paras.size() < 2)
//			// TODO raise exception for wrong number of parameters
//			return;
		
		MuaValue latterPara = paras.pop();
		MuaValue formerPara = paras.pop();
		
		// judge the type
		if(formerPara instanceof MuaBool) {
			this.formerOperand = (MuaBool)formerPara;
		} else if(formerPara instanceof MuaWord) {
			this.formerOperand = ((MuaWord)formerPara).getMuaBool();
		} else {
			// TODO operand must be number
		}
		
		if(latterPara instanceof MuaBool) {
			this.latterOperand = (MuaBool)latterPara;
		} else if(formerPara instanceof MuaWord) {
			this.latterOperand = ((MuaWord)latterPara).getMuaBool();
		} else {
			// TODO operand must be number
		}

	}
	
	@Override
	public abstract void execute(Stack<MuaValue> paras, Namespace namespace);
	
	public int getParaNum() {
		return 2;
	}
	
}
