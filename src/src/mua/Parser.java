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
	public static List<String> paraList = new ArrayList<>();
	private static Stack<MuaValue> runStack = new Stack<>();
	private static Stack<String> parseListStack = new Stack<>();

	public Parser() {
		super();
	}
	
	public static boolean parse(Namespace namespace) {
		
		// return false means can not get parameters, error
		
		// execute a single parameter
		String para = getNextPara();
		if(para == null)
			return false;
//		System.out.println(para.substring(0, 1));
		// basic operation
		if(Operation.checkOp(para)) {
			Operation op = Operation.getOperation(para);
			int numOfPara = op.getParaNum();
			for(int i = 0; i < numOfPara; i++) parse(namespace);
			op.execute(runStack, namespace);
		}
		else if(namespace.existFunc(para)) {
			MuaList func = namespace.getFunc(para);
			Namespace funcNamespace = new Namespace();
			funcNamespace.createName(para, func);
			
			MuaList argName = (MuaList)func.get(0);
			
			// create parameters
			for(int i = 0; i < argName.size(); i++) {
				parse(namespace);
				MuaValue v = runStack.pop();
				funcNamespace.createName((String)argName.get(i), v);
			}
			
			parseFunc(funcNamespace, func);
		}
		else if(para.substring(0, 1).equals(":")){
			Operation op = Operation.getOperation("thing");
			MuaValue value = new MuaWord(para.substring(1, para.length()), true);
			runStack.push(value);
			op.execute(runStack, namespace);
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
		return true;
	}
	
	private static void parseFunc(Namespace funcNamespace, MuaList func) {
		MuaList program = (MuaList)func.get(1);
		
		// clone the paraList
		List<String> tempParaList = new ArrayList<>();
		for(int i = 0; i < paraList.size(); i++)
			tempParaList.add(paraList.get(i));
		paraList.clear();
		
		// execute program
		String inst = program.getOriginList();
		String[] elements = inst.split("\\s+");
		// check empty
		if(!inst.isEmpty()) {
			for(int j = elements.length - 1; j >= 0; j--) paraList.add(0, elements[j]);
		}
		while(!paraList.isEmpty())
			parse(funcNamespace);
//		System.out.println("out!");
		MuaValue output = funcNamespace.getResult();
		if(output != null)
//			System.out.println(((MuaNumber)output).getValue());
			runStack.push(output);
		
		for(int i = 0; i < tempParaList.size(); i++)
			paraList.add(tempParaList.get(i));
		return;
	}
	
	private static MuaList parseList() {
		MuaList l = new MuaList();
		String para = parseListStack.pop();
		while(true) {
//			String frontChar = para.substring(0, 1);
//			String endChar = para.substring(para.length() - 1, para.length());
			int frontParenthese = para.indexOf("[");
			int endParenthese = para.indexOf("]");
			if(frontParenthese != -1) {
				if(!para.substring(0, frontParenthese).isEmpty())
					l.add(para.substring(0,  frontParenthese));
				String rest = para.substring(frontParenthese + 1, para.length());
				parseListStack.push(rest);
				MuaList l_temp = parseList();
				l.add(l_temp);
			}
			else if(endParenthese != -1) {
				if(!para.substring(0, endParenthese).isEmpty())
					l.add(para.substring(0, endParenthese));
				String rest = para.substring(endParenthese + 1, para.length());
				if(!rest.isEmpty())
					parseListStack.push(rest);
				break;
			}
			else {
				if(!para.isEmpty())
					l.add(para);
			}
			
			if(parseListStack.isEmpty()) {
				String newPara = getNextPara();
//				if(newPara == null)
					//TODO error for read ending
				parseListStack.push(newPara);
			}
			para = parseListStack.pop();
		}
		return l;
	}

	private static String getNextPara() {
		// return parameter if exists, otherwise return NULL
		String para = null;
		boolean read = true;
		while(true) {
			if(paraList.isEmpty()) read = readNext();
			if(!read) return null;
			if(paraList.isEmpty()) continue;
			para = paraList.get(0);
			paraList.remove(0);
			if(!para.isEmpty()) break;
		}
		return para;
	}
	
	private static boolean readNext() {
		// read an instruction
		if(!sc.hasNext()) {
			// TODO: error for read nothing
			return false;
		}
		String inst = sc.nextLine();
		
		// delete comment
		int commentIndex = inst.indexOf("//");
		if(commentIndex != -1) {
			inst = inst.substring(0, commentIndex);
		}
		
		// divide into parameters
		String[] paras = inst.split("\\s+");
		// check empty
		if(!inst.isEmpty()) {
			for(int i = 0; i < paras.length; i++) paraList.add(paras[i]);
		}
		
		return true;
	}
}
