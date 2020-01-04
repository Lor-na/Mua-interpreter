package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class JoinOp extends Operation {

	public JoinOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue value2 = paras.pop();
		MuaList list1 = (MuaList)paras.pop();
		
		MuaList l = list1.getCopy();
		
		if(value2 instanceof MuaList) {
			l.add(((MuaList) value2).getCopy());
		}else {
			String s2;
			if(value2 instanceof MuaWord)
				s2 = ((MuaWord)value2).getValue();
			else if(value2 instanceof MuaBool)
				s2 = ((MuaBool)value2).getValue() ? "true" : "false";
			else
				s2 = String.valueOf(((MuaNumber)value2).getValue());
			l.add(s2);
		}
		
		paras.push(l);
		return ;

	}
	
	
	@Override
	public int getParaNum() {
		return 2;
	}

}
