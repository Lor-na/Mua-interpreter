package src.mua;

public class Main {
	
	public static void main(String args[]) {
		
		Parser parser = new Parser();
		
		while(parser.readNext()) {
			parser.parse();
		}
	}
}
