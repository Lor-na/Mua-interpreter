package src.mua;

import src.name.Namespace;

public class Main {
	
	public static Namespace globalNameSpace = new Namespace();
	
	public static void main(String args[]) {

		boolean res = true;
		
		while(res) {
			res = Parser.parse(globalNameSpace);
		}
		
		return;
	}
}
