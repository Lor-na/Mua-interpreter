package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class GreaterThanOp extends OperatorForCmp {

	public GreaterThanOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		super.preCompare(paras);
		
		boolean res;
		
		if(super.formerOperand instanceof MuaNumber) {
			double formerNum, latterNum;
			formerNum = ((MuaNumber)super.formerOperand).getValue();
			latterNum = ((MuaNumber)super.latterOperand).getValue();
			if(formerNum > latterNum)
				res = true;
			else
				res = false;
		}else {
			String formerWord, latterWord;
			formerWord = ((MuaWord)super.formerOperand).getValue();
			latterWord = ((MuaWord)super.latterOperand).getValue();
			if(formerWord.compareTo(latterWord) > 0)
				res = true;
			else 
				res = false;
		}
		
		MuaValue v = new MuaBool(res);
		paras.push(v);

	}

}
