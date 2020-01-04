package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;

public class ErallOp extends Operation {

	public ErallOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		
		namespace.clean();

	}

	@Override
	public int getParaNum() {
		return 0;
	}

}
