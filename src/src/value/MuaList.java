package src.value;

import java.util.ArrayList;
import java.util.List;

public class MuaList extends MuaValue {
	
	private List<Object> value;
	
	public MuaList() {
		this.value = new ArrayList<>();
	}
	
	public void add(Object element) {
		if(element instanceof MuaList || element instanceof String) {
			value.add(element);
		}
		else {
			// TODO raise error for add wrong type
		}
		return;
	}

	@Override
	public void print() {
		System.out.print("[ ");
		for(int i = 0; i < value.size(); i++) {
			if(value.get(i) instanceof String) 
				System.out.print(value.get(i) + " ");
			else
				((MuaList)value.get(i)).print();
		}
		System.out.print("]");
	}

}
