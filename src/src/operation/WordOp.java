package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaBool;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class WordOp extends Operation {

	public WordOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		if (paras.size() < 1) {
			// TODO wrong number of parameter
			return;
		}
		
		MuaValue word2 = paras.pop();
		String s2;
		if(word2 instanceof MuaWord)
			s2 = ((MuaWord)word2).getValue();
		else if(word2 instanceof MuaBool)
			s2 = ((MuaBool)word2).getValue() ? "true" : "false";
		else
			s2 = String.valueOf(((MuaNumber)word2).getValue());
		
		MuaWord word1 = (MuaWord)paras.pop();
		MuaWord res = word1.attach(s2);
		
		paras.push(res);
		return ;

	}

	@Override
	public int getParaNum() {
		return 2;
	}

}
