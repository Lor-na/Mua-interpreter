package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public abstract class OperatorForCmp extends Operation {

	protected MuaValue formerOperand;
	protected MuaValue latterOperand;
	
	public OperatorForCmp() {
	}

	protected int preCompare(Stack<MuaValue> paras) {
//		if(paras.size() < 2)
//			// TODO raise exception for wrong number of parameters
//			return -2;
		
		MuaValue latterPara = paras.pop();
		MuaValue formerPara = paras.pop();
		
		// judge the type
		if(formerPara instanceof MuaWord && latterPara instanceof MuaWord) {
			// both word
			this.formerOperand = formerPara;
			this.latterOperand = latterPara;
		} else if(formerPara instanceof MuaNumber && latterPara instanceof MuaWord) {
			// one word to number
			this.formerOperand = formerPara;
			this.latterOperand = ((MuaWord)latterPara).getMuaNumber();
		} else if(formerPara instanceof MuaWord && latterPara instanceof MuaNumber) {
			// one word to number
			this.formerOperand = ((MuaWord)formerPara).getMuaNumber();
			this.latterOperand = latterPara;
		} else if(formerPara instanceof MuaNumber && latterPara instanceof MuaNumber){
			// both number
			this.formerOperand = formerPara;
			this.latterOperand = latterPara;
		} else {
			return -1;
		}
		
		return 0;
	}
	
	@Override
	public abstract void execute(Stack<MuaValue> paras, Namespace namespace);
	
	public int getParaNum() {
		return 2;
	}

}
