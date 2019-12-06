package src.mua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import src.name.Namespace;
import src.operation.Operation;
import src.value.MuaValue;
import src.value.MuaWord;

public class Parser {
	public static Scanner sc = new Scanner(System.in);
	private List<String> paraList;
	private Stack<MuaValue> runStack;
	
	private Namespace globalNameSpace;

	public Parser() {
		super();
		this.paraList = new ArrayList<>();
		this.runStack = new Stack<>();
		this.globalNameSpace = new Namespace();
	}
	
	public void parse() {
		// execute a single parameter
		String para = this.getNextPara();
//		System.out.println(para.substring(0, 1));
		// basic operation
		if(Operation.checkOp(para)) {
			Operation op = Operation.getOperation(para);
			int numOfPara = op.getParaNum();
			for(int i = 0; i < numOfPara; i++) parse();
			op.execute(runStack, globalNameSpace);
		}
		else if(para.substring(0, 1).equals(":")){
			Operation op = Operation.getOperation("thing");
			MuaValue value = new MuaWord(para.substring(1, para.length()), true);
			runStack.push(value);
			op.execute(runStack, globalNameSpace);
		}
		else {
			MuaValue value = MuaValue.getValue(para);
			runStack.push(value);
		}
		return;
	}
	
	private MuaValue MuaWord(String substring) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getNextPara() {
		// return para if exists, otherwise return NULL
		if(paraList.isEmpty()) this.readNext();
		String para = paraList.get(0);
		paraList.remove(0);
		return para;
	}
	
	private void readNext() {
		// read an instruction
		if(!sc.hasNext()) {
			// TODO: error for read nothing
			return;
		}
		String inst = sc.nextLine();
		
		// delete comment
		int commentIndex = inst.indexOf("//");
		if(commentIndex != -1) {
			inst = inst.substring(0, commentIndex);
		}
		
		// divide into parameters
		String[] paras = inst.split("\\s+");
		for(int i = 0; i < paras.length; i++) paraList.add(paras[i]);
		
		return;
	}
}
