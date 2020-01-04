package src.operation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import src.name.Namespace;
import src.value.MuaValue;
import src.value.MuaWord;

public class SaveOp extends Operation {

	public SaveOp() {
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
		String npContent = namespace.getMap();
	         
	    FileWriter writer = null;
	    try {
	    	writer = new FileWriter(fileName);
	    	writer.write(npContent);
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    finally {
	    	try {
	    		writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	}

	@Override
	public int getParaNum() {
		// TODO Auto-generated method stub
		return 1;
	}

}
