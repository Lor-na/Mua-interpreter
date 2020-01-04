package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;

public class OutputOp extends Operation {

	public OutputOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaValue res = paras.pop();
		
//		System.out.println("Output func:");
//		res.print();
		
		namespace.setResult(res);
		return;
	}

	@Override
	public int getParaNum() {
		return 1;
	}

}
