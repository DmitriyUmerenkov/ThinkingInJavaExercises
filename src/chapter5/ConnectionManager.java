package chapter5;


class Connection {
	Connection() { System.out.println("Creating Connection");  };
}


public class ConnectionManager {
	static Connection[] c = new Connection[10];
 static
	{
		for (int i=0;i<10;i++)	c[i]=new Connection();	
		
	}	
	

	public static Connection getConnection() 
	{
		count++;
		if (count>10) return null;
		else return c[count-1];
	}	
	
	
	private static int count;
	
	
}


