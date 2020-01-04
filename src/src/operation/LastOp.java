package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class LastOp extends Operation {

	public LastOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if (paras.size() < 2) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue v = paras.pop();
		
		if(v instanceof MuaList) {
			// list
			Object o = ((MuaList) v).get(((MuaList) v).size() - 1);
			if(o instanceof String) {
				MuaWord w = new MuaWord((String)o, true);
				paras.push(w);
			}else if(o instanceof MuaList) {
				MuaList l = ((MuaList) o).getCopy();
				paras.push(l);
			}
		}else {
			String s = "";
			if(v instanceof MuaWord) {
				s = ((MuaWord) v).getValue();
			}else if(v instanceof MuaBool) {
				s = ((MuaBool)v).getValue() ? "true" : "false";
			}else if(v instanceof MuaNumber) {
				s = String.valueOf(((MuaNumber)v).getValue());
			}
			MuaWord w = new MuaWord(s.substring(s.length() - 1, s.length()), true);
			paras.push(w);
		}
		
	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
