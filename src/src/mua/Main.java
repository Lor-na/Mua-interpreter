package src.mua;

import src.name.Namespace;

public class Main {
	
	public static Namespace globalNameSpace = new Namespace();
	
	public static void main(String args[]) {
		
		Parser parser = new Parser();
		
		while(true) {
			parser.parse(globalNameSpace);
		}
	}
}
