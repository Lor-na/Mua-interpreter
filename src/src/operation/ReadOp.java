package src.operation;

import java.util.Stack;

import src.mua.Parser;
import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class ReadOp extends Operation {

	public ReadOp() {
	}

	@Override
	public void execute(Stack<MuaValue> paras, Namespace namespace) {
		String content = null;
		if(Parser.sc.hasNext())
			content = Parser.sc.nextLine();
		// TODO illegal content and no content for reading
		
		// TODO the read src.value must be number or word
		MuaValue v = new MuaWord(content, true);
		paras.push(v);
	}

}
