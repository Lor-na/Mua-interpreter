package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class FirstOp extends Operation {

	public FirstOp() {
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
			Object o = ((MuaList) v).get(0);
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
			MuaWord w = new MuaWord(s.substring(0, 1), true);
			paras.push(w);
		}

	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
