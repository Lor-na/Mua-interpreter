package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaValue;
import src.value.MuaWord;

public abstract class OperatorForLogicOne extends Operation{
	
	protected MuaBool operand;
	
	public OperatorForLogicOne() {
	}
	
	protected void preCalculate(Stack<MuaValue> paras) {
		if(paras.size() < 1)
			// TODO raise exception for wrong number of parameters
			return;
		
		MuaValue para = paras.pop();
		
		// judge the type
		if(para instanceof MuaBool) {
			this.operand = (MuaBool)para;
		} else if(para instanceof MuaWord) {
			this.operand = ((MuaWord)para).getMuaBool();
		} else {
			// TODO operand must be number
		}

	}

	@Override
	public abstract void execute(Stack<MuaValue> paras, Namespace namespace);
	
	public int getParaNum() {
		return 1;
	}
}
