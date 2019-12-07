package src.mua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import src.name.Namespace;
import src.operation.Operation;
import src.value.MuaList;
import src.value.MuaValue;
import src.value.MuaWord;

public class Parser {
	public static Scanner sc = new Scanner(System.in);
	private List<String> paraList;
	private Stack<MuaValue> runStack;
	private Stack<String> parseListStack;
	
	private Namespace globalNameSpace;

	public Parser() {
		super();
		this.paraList = new ArrayList<>();
		this.runStack = new Stack<>();
		this.globalNameSpace = new Namespace();
		this.parseListStack = new Stack<>();
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
		else if(para.substring(0,1).equals("[")) {
			parseListStack.clear();
			parseListStack.push(para.substring(1, para.length()));
			MuaList list;
			list = parseList();
			runStack.push(list);
		}
		else {
			MuaValue value = MuaValue.getValue(para);
			runStack.push(value);
		}
		return;
	}
	
	private MuaList parseList() {
		MuaList l = new MuaList();
		String para = parseListStack.pop();
		while(true) {
//			String frontChar = para.substring(0, 1);
//			String endChar = para.substring(para.length() - 1, para.length());
			int frontParenthese = para.indexOf("[");
			int endParentheses = para.indexOf("]");
			if(frontParenthese != -1) {
				l.add(para.substring(0,  frontParenthese));
				String rest = para.substring(frontParenthese + 1, para.length());
				parseListStack.push(rest);
				MuaList l_temp = parseList();
				l.add(l_temp);
			}
			else if(endParentheses != -1) {
				l.add(para.substring(0, endParentheses));
				String rest = para.substring(endParentheses + 1, para.length());
				if(!rest.isEmpty())
					parseListStack.push(rest);
				break;
			}
			else
				l.add(para);
			
			if(parseListStack.isEmpty()) {
				String newPara = getNextPara();
				parseListStack.push(newPara);
			}
			para = parseListStack.pop();
		}
		return l;
	}

	private String getNextPara() {
		// return parameter if exists, otherwise return NULL
		String para;
		while(true) {
			if(paraList.isEmpty()) this.readNext();
			para = paraList.get(0);
			paraList.remove(0);
			if(!para.isEmpty()) break;
		}
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
