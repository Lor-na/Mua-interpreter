package src.mua;

import java.util.Scanner;
import java.util.Stack;

import src.name.Namespace;
import src.operation.Operation;
import src.value.MuaValue;

public class Parser {
	public static Scanner sc = new Scanner(System.in);
	private Stack<String> paraStack;
	private Stack<MuaValue> runStack;
	
	private Namespace globalNameSpace;

	public Parser() {
		super();
		this.paraStack = new Stack<>();
		this.runStack = new Stack<>();
		this.globalNameSpace = new Namespace();
	}
	
	
	public void parse() {
		
		// read instruction
		// TODO take exception
		String inst = sc.nextLine();
		inst = inst.replace(" :", " thing \"");
		int commentIndex = inst.indexOf("//");
		if(commentIndex != -1) {
			inst = inst.substring(0, commentIndex);
		}
		
		String[] paras = inst.split("\\s+");
		
		// push into stack
		paraStack.clear();
		for(int i = 0; i < paras.length; i++) {
			paraStack.push(paras[i]);
		}
			
		
		// pop and execute
		runStack.clear();
		while(!paraStack.isEmpty()) {
			// TODO error for non-empty stack(includes runStack)
			String para = paraStack.pop();
			if(Operation.checkOp(para)) {
				Operation op = Operation.getOperation(para);
				op.execute(runStack, globalNameSpace);
			}else {
				MuaValue value = MuaValue.getValue(para);
				runStack.push(value);
			}
		}
		
//		globalNameSpace.print();
	}
	
	
	public boolean readNext() {
		// System.out.println(sc.hasNext());
		return sc.hasNext();
	}
}
