package containers;

import util.Countries;
import java.util.*;

public class Ex2and3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,String> aMap=new HashMap<String,String>();
		for (Map.Entry<String, String> anEntry: Countries.capitals().entrySet()) {
			if (anEntry.getKey().charAt(0)=='A') aMap.put(anEntry.getKey(), anEntry.getValue());
		}
		Set<String> aSet = aMap.keySet();
		
		
System.out.println(aMap);
System.out.println(aSet);


Set<String> aSet1=new HashSet<String>(Countries.capitals(10).keySet()); 
Set<String> aSet2=new LinkedHashSet<String>(Countries.capitals(10).keySet()); 
Set<String> aSet3=new TreeSet<String>(Countries.capitals(10).keySet()); 

System.out.println(aSet1);
System.out.println(aSet2);
System.out.println(aSet3);

aSet1.addAll(Countries.capitals(10).keySet());
aSet2.addAll(Countries.capitals(10).keySet());
aSet3.addAll(Countries.capitals(10).keySet());

System.out.println(aSet1);
System.out.println(aSet2);
System.out.println(aSet3);


	}
	

	
	

}
