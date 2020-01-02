package src.value;

import java.util.ArrayList;
import java.util.List;

public class MuaList extends MuaValue {
	
	private List<Object> value;
	
	public MuaList() {
		this.value = new ArrayList<>();
	}
	
	public void add(Object element) {
		if(element instanceof MuaList) {
			value.add(((MuaList) element).getCopy());
		}
		else if(element instanceof String) {
			value.add(element);
		}
		else {
			// TODO raise error for add wrong type
		}
		return;
	}
	
	public String getOriginList() {
		// res without the outside parenthesis
		String res = "";
		for(int i = 0; i < value.size(); i++) {
			if(value.get(i) instanceof String)
				res += value.get(i) + " ";
			else
				res += "[" + ((MuaList)value.get(i)).getOriginList() + "] ";
		}
		return res;
	}
	
	public int size() {
		return value.size();
	}
	
	public Object get(int index) {
		return value.get(index);
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
	
	public MuaList getCopy() {
		MuaList res = new MuaList();
		for(int i = 0; i < value.size(); i++) {
			if(value.get(i) instanceof MuaList) {
				MuaList tempRes = ((MuaList)(value.get(i))).getCopy();
				res.add(tempRes);
			}else {
				String tempS = (String)value.get(i);
				res.add(tempS);
			}
		}
		return res;
	}

}
