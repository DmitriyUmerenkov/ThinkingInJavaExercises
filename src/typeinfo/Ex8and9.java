package typeinfo;

import java.lang.reflect.Field;

public class Ex8and9 {

	
	public static void classinfo(Object obj) {
		System.out.println("Class name="+ obj.getClass().getName());
		System.out.println("Fields count "+ obj.getClass().getDeclaredFields().length);
		
		for (Field f: obj.getClass().getDeclaredFields())
		System.out.println("Field:"+f );
		
		
		if (obj.getClass().getSuperclass()!=null) {
			System.out.println("Has superclass "+obj.getClass().getSuperclass().getName());
			try {
			classinfo(obj.getClass().getSuperclass().newInstance());
			}
			catch (Exception e) {
				System.out.println("Exception thrown "+e);
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classinfo(new Integer(1));
		
		
	}

}
