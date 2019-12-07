package src.operation;

import java.util.Stack;

import src.mua.Parser;
import src.name.Namespace;
import src.value.MuaList;
import src.value.MuaValue;

public class ReadListOp extends Operation {

	public ReadListOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		String content = null;
		if(Parser.sc.hasNext())
			content = Parser.sc.nextLine();
		// TODO illegal content and no content for reading
		
		// divide into parameters
		String[] elementArray = content.split("\\s+");
		
		// TODO the read src.value must be number or word
		MuaList l = new MuaList();
		for(int i = 0; i < elementArray.length; i++) 
			l.add(elementArray[i]);
		
		paras.push((MuaValue)l);
	}

	@Override
	public int getParaNum() {
		return 0;
	}

}
