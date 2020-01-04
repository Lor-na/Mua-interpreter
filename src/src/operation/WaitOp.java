package src.operation;

import java.util.Stack;

import src.name.Namespace;
import src.value.MuaNumber;
import src.value.MuaValue;

public class WaitOp extends Operation {

	public WaitOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
//		if(paras.size() < 1)
//			// TODO raise exception for wrong number of parameters
//			return;
		
		MuaNumber v = (MuaNumber)paras.pop();
		
		long val = (long) Math.floor(v.getValue());
		
		try {
            Thread.sleep(val);
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
		
		return;

	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
