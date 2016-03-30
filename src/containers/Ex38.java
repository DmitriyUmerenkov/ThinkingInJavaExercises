package containers;
import util.*;
import java.util.*;
import java.lang.reflect.*;
public class Ex38 {
	
	 static List<Test<Map<Integer,String>>> tests =
			    new ArrayList<Test<Map<Integer,String>>>();
			  static {
			    tests.add(new Test<Map<Integer,String>>("get") {
			      int test(Map<Integer,String> map, TestParam tp) {
			        int loops = tp.loops;
			        int span = tp.size * 2;
			        for(int i = 0; i < loops; i++)
			          for(int j = 0; j < span; j++)
			            map.get(j);
			        return loops * span;
			      }
			    });
			    tests.add(new Test<Map<Integer,String>>("iterate") {
			      int test(Map<Integer,String> map, TestParam tp) {
			        int loops = tp.loops * 10;
			        for(int i = 0; i < loops; i ++) {
			          Iterator it = map.entrySet().iterator();
			          while(it.hasNext())
			it.next(); }
			        return loops * map.size();
			      }
			}); }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> firstMap = new HashMap<Integer,String>(new CountingMapData(1000));
		
		   Tester.run(firstMap, tests);
	
		try {
		Field tableField = HashMap.class.getDeclaredField("table");
		tableField.setAccessible(true);
		Object[] table = (Object[]) tableField.get(firstMap);
		System.out.print("firstMap capacity:");
		System.out.println(table == null ? 0 : table.length);
		System.out.println("LoadFactor="+(float)firstMap.size()/table.length);
		}
		catch (Exception e) {}
		
		Map<Integer,String> secondMap = new HashMap<Integer,String>(8192);
		secondMap.putAll(firstMap);
		
		Tester.run(secondMap, tests);
	
		try {
			Field tableField = HashMap.class.getDeclaredField("table");
			tableField.setAccessible(true);
			Object[] table = (Object[]) tableField.get(secondMap);
			System.out.print("SecondMap  capacity:");
			System.out.println(table == null ? 0 : table.length);
			System.out.println("LoadFactor="+(float)secondMap.size()/table.length);
			
			}
			catch (Exception e) {}
	

	}

}
