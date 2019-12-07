package src.operation;

import java.util.Stack;

import src.mua.Parser;
import src.name.Namespace;
import src.value.MuaValue;

public class StopOp extends Operation {

	public StopOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		Parser.paraList.clear();
	}

	@Override
	public int getParaNum() {
		return 0;
	}

}
