package chapter4;





public class Ex21_22 {

	public static void main(String[] args) {
		for (Bills b: Bills.values())
		{
			System.out.print("ORDINAL " + b.ordinal());
			System.out.println(" VALUE " + b);
		}
	Bills r = Bills.RUBLE,
		d=Bills.DOLLAR,
		p=Bills.PESO,
		b=Bills.BAT,
		c=Bills.CRONA;
	
	
	printNickname(r);
	printNickname(d);
	printNickname(p);
	printNickname(b);
	printNickname(c);
	
	
	
	}

	static void printNickname(Bills a)
	{
		switch (a) {
		case RUBLE: System.out.println("Wooden"); break;
		case DOLLAR: System.out.println("Greenback"); break;
		case PESO: System.out.println("Sombrero"); break;
		case CRONA: System.out.println("Crown"); break;
		case BAT: System.out.println("None"); break;
		
		}
	}
	
	
	
}
