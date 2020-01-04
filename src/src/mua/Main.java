package src.mua;

import src.name.Namespace;

public class Main {
	
	public static Namespace globalNameSpace = new Namespace();
	
	public static void main(String args[]) {

		boolean res = true;
		
		String inst = "make \"pi 3.14159\nmake \"run [[list] [repeat 1 :list]]";
		String[] elements = inst.split("\\s+");
		for(int j = elements.length - 1; j >= 0; j--) Parser.paraList.add(0, elements[j]);
		while(!Parser.paraList.isEmpty())
			Parser.parse(globalNameSpace);
		
		while(res) {
			res = Parser.parse(globalNameSpace);
		}
		
		return;
	}
}
