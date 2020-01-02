package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class SentenceOp extends Operation {

	public SentenceOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if (paras.size() < 1) {
			// TODO wrong number of parameter
			return;
		}
		
		MuaValue value2 = paras.pop();
		MuaValue value1 = paras.pop();
		MuaList l = new MuaList();
		
		parseValue(l, value1);
		parseValue(l, value2);
		
		paras.push(l);
		return ;
	}
	
	private void parseValue(MuaList l, MuaValue p) {
		if(p instanceof MuaList) {
			MuaList list1 = ((MuaList) p).getCopy();
			for(int i = 0; i < list1.size(); i++) {
				l.add(list1.get(i));
			}
		}else {
			String s1;
			if(p instanceof MuaWord)
				s1 = ((MuaWord)p).getValue();
			else if(p instanceof MuaBool)
				s1 = ((MuaBool)p).getValue() ? "true" : "false";
			else
				s1 = String.valueOf(((MuaNumber)p).getValue());
			l.add(s1);
		}
	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 2;
	}

}
