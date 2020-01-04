package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;

public class PrintOp extends Operation {

	public PrintOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue name = paras.pop();
		name.print();
	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
