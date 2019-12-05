package src.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isType(Pattern pattern, String content) {
		if (content == null)
			// TODO raise exception for empty content
			return false;
		Matcher matcher = pattern.matcher(content);
		boolean res = matcher.matches();
		return res;
	}

}
