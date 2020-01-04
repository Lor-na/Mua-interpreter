package src.operation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import src.mua.Parser;
import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class LoadOp extends Operation {

	public LoadOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		
//		if (paras.size() < 1) {
//			// TODO wrong number of parameter
//			return;
//		}
		
		MuaWord word = (MuaWord)paras.pop();
		
		String fileName = word.getValue();
		String s = "";
		
	    try {
	    	FileReader reader = new FileReader(fileName);
	    	char[] chs = new char[1024];
	    	int num;
	        while((num = reader.read(chs)) != -1){
	        	s += new String(chs, 0, num);
	        }
	        reader.close();
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    System.out.println(s);
	    
	    String[] elements = s.split("\\s+");
		if(!s.isEmpty())
			for(int j = elements.length - 1; j >= 0; j--) Parser.paraList.add(0, elements[j]);
		
		while(!Parser.paraList.isEmpty())
			Parser.parse(namespace);
	    
	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
