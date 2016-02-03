package strings;

import java.util.regex.*;

public class Ex10and11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1="Java now has regular expressions";
		String[] regex1 = new String[] {
				"Java",
				"\\Breg.*",
				"n.w\\s+h(a|i)s",
				"s?",
				"s*",
				"s+",
				"s{4}",
				"S{1}.",
				"s{0,3}"				
		};
		
		for (String r: regex1) {
			Pattern p = Pattern.compile(r);
			Matcher m =p.matcher(input1);
			//System.out.println("Pattern \""+r+ "\" matches \"" + input1+"\" is " + m.matches());
			System.out.println("Pattern \""+r+ "\" is contained in \"" + input1+"\" is " + m.find());
		}
		
		String input2="Arline ate eight apples and one orange while Anita hadn’t any";
		Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
		Matcher m = p.matcher(input2);
		
		
		while(m.find())
		System.out.println(m.group());
				
		
	}

}
