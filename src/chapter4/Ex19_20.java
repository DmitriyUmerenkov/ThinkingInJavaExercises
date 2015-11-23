package chapter4;

public class Ex19_20 {

static void printStrings(String... str)
{
	for (String s: str)
		System.out.println(s);
	
}
	
	
	
	public static void main(String[] args) {
		printStrings ("One","Two","Three");
		printStrings (new String[] {"One1","Two2","Three3"});
		
		Other.main("11","22","33");
		
	
	}

}

class Other {
	
	public static void main(String... args) {
		for (String s: args)
			System.out.println(s);
	
	}	
	
}