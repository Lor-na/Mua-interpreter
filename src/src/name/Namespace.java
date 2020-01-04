package src.name;

import java.util.HashMap;
import java.util.regex.Pattern;

import src.operation.Operation;
import src.util.Util;
import src.value.MuaBool;
import src.value.MuaList;
import src.value.MuaNumber;
import src.value.MuaValue;
import src.value.MuaWord;

public class Namespace {

	private static final Pattern pattern = Pattern.compile("^[A-Za-z]+[A-Za-z0-9_]*");
	private HashMap<String, MuaValue> nameMap = new HashMap<>();
	private MuaValue funcResult;
	
	public Namespace() {
	}
	
	public void clean() {
		nameMap.clear();
	}
	
	public String getMap(){
		String s = "";
		for(String key : nameMap.keySet() ) {
			MuaValue v = nameMap.get(key);
			s += "make \"" + key + " ";
			if(v instanceof MuaList) {
				s += "[" + ((MuaList) v).getOriginList() + "]";
			} else if(v instanceof MuaWord) {
				s += ((MuaWord) v).getValue();
			} else if(v instanceof MuaBool) {
				s += (((MuaBool) v).getValue()) ? "true" : "false";
			} else {
				s += String.valueOf(((MuaNumber)v).getValue());
			}
			s += "\n";
		}
		return s;
	}
	
	public void setResult(MuaValue output) {
		funcResult = output;
	}
	
	public MuaValue getResult() {
		return funcResult;
	}
	
	public static boolean isLegalName(String content) {
		return Util.isType(pattern, content) && !Operation.checkOp(content);
	}
	
	public void createName(MuaWord name, MuaValue value) {
		if(!isLegalName(name.getValue())) {
			// TODO raise exception
		}
		nameMap.put(name.getValue(), value);
	}
	
	public void createName(String name, MuaValue value) {
		if(!isLegalName(name)) {
			// TODO raise error
		}
		nameMap.put(name, value);
	}
	
	public void eraseName(MuaWord name) {
		if(!isLegalName(name.getValue())) {
			// TODO raise exception
		}
		if(!nameMap.containsKey(name.getValue())) {
			// TODO not exist this key
		}
		nameMap.remove(name.getValue());
	}
	
	public boolean existName(MuaWord name) {
		if(!isLegalName(name.getValue())) {
			// TODO raise exception
		}
		return nameMap.containsKey(name.getValue());
	}
	
	public MuaValue getValue(MuaWord name) {
		if(!nameMap.containsKey(name.getValue())) {
			return null;
		}
		return nameMap.get(name.getValue());
	}
	
	public boolean existFunc(String name) {
		if(!nameMap.containsKey(name))
			return false;
		else {
			MuaValue func = nameMap.get(name);
//			func.print();
			if(func instanceof MuaList && ((MuaList) func).size() == 2)
				return true;
			else
				return false;
		}
	}
	
	public MuaList getFunc(String name) {
		// TODO: don't exist
		MuaValue func = nameMap.get(name);
		return (MuaList)func;
	}
	
	
	public void print() {
		for(String key : nameMap.keySet()) {
			System.out.println(key);
			MuaValue v = nameMap.get(key);
			if(v instanceof MuaNumber) {
				MuaNumber n = (MuaNumber)v;
				n.print();
			} else if(v instanceof MuaWord) {
				MuaWord w = (MuaWord)v;
				w.print();
			}
		}
	}
	
}
