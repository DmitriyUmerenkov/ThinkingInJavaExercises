package typeinfo;

import java.lang.reflect.Method;

import typeinfo.inner.Inner;;

public class Ex25 {

	public static void main (String[] Args) {
		Inner Obj = new Inner();
		
		for (Method m: Obj.getClass().getDeclaredMethods())
		{
			if(!m.isAccessible()) m.setAccessible(true);
			
			
			try {
			m.invoke(Obj, (Object[])null);
				}
			catch (Exception e) {
				
				System.out.println(e);
				
			}
			
		}
		
		
	}
	
	
}
