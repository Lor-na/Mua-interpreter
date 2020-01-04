package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class ButFirstOp extends Operation {

	public ButFirstOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue v = paras.pop();

		if(v instanceof MuaList) {
			// list
			MuaList l = new MuaList();
			
			MuaList tempL = ((MuaList) v).getCopy();
			for(int i = 1; i < tempL.size(); i++) {
				l.add(tempL.get(i));
			}
			
			paras.push(l);
		}else {
			String s = "";
			if(v instanceof MuaWord) {
				s = ((MuaWord) v).getValue();
			}else if(v instanceof MuaBool) {
				s = ((MuaBool)v).getValue() ? "true" : "false";
			}else if(v instanceof MuaNumber) {
				s = String.valueOf(((MuaNumber)v).getValue());
			}
			MuaWord w = new MuaWord(s.substring(1, s.length()), true);
			paras.push(w);
		}
		
		
	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
