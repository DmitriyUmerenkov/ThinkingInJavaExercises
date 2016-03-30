package containers;

import util.*;
import java.util.*;

import containers.ListPerformance.ListTester;



class StringContainer extends AbstractList 
{
	public void clear() {data=new String[10];index=0;}
	
	
	StringContainer() {super(); data=new String[10];}
	StringContainer(int size) {super(); data=new String[size];}
	
	String[] data;
	int index;
	
	private void resize()
	{	
	 if (index==data.length) 
	{
		String[] newdata = new String[data.length+data.length/2]; 
		for (int i=0;i<data.length;i++) 
			newdata[i]=data[i];
		data=newdata;
	}
	
}
	void add(String s) 
	{
	resize();
	data[index++]=s;
	}

	public String get(int position) {return data[position];}
	
	void insert(int position, String s) {
	resize();
	  for (int i=data.length-1;i>=position;i--)
		  data[i]=data[i-1];
	 data[position]=s;
	 index++;
	}
	
	
	
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
						
			int itpos=-1;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (itpos<index-1);
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return data[++itpos];
			}
			public void add(String s ) {
				
			insert(++itpos,s);	
				
				
			}
		
		
		};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.length;
	}
}




public class Ex31 {
	
	static List<Test<List<String>>> tests =
		    new ArrayList<Test<List<String>>>();
	
		  static List<Test<StringContainer>> qTests =
		    new ArrayList<Test<StringContainer>>();
		  
		  static Random rand=new Random();
		  
		  public static TestParam[] defaultParams= TestParam.array(
				    10, 5000, 100, 5000, 1000, 5000, 10000, 500);
		  static int reps = 1000;
		  
		  static {

			    tests.add(new Test<List<String>>("add") {
				      int test(List<String> list, TestParam tp) {
				        int loops = tp.loops;
				        int listSize = tp.size;
				        for(int i = 0; i < loops; i++) {
				          list.clear();
				          for(int j = 0; j < listSize; j++)
				            list.add(""+j);
				        }
				        return loops * listSize;
				      }
				    });
			  
		    
		    tests.add(new Test<List<String>>("get") {
		      int test(List<String> list, TestParam tp) {
		        int loops = tp.loops * reps;
		        int listSize = list.size();
		        for(int i = 0; i < loops; i++)
		          list.get(rand.nextInt(listSize));
		        return loops;
		} });
		    
	    

		tests.add(new Test<List<String>>("insert") {
		  int test(List<String> list, TestParam tp) {
		    int loops = tp.loops;
		    for(int i = 0; i < loops; i++)
		      list.add(5, "47"); // Minimize random-access cost
		    return loops;
		} });
	
		
		
	    qTests.add(new Test<StringContainer>("add") {
		      int test(StringContainer list, TestParam tp) {
		        int loops = tp.loops;
		        int listSize = tp.size;
		        for(int i = 0; i < loops; i++) {
		          list.clear();
		          for(int j = 0; j < listSize; j++)
		            list.add(""+j);
		        }
		        return loops * listSize;
		      }
		    });
	  
  
  qTests.add(new Test<StringContainer>("get") {
    int test(StringContainer list, TestParam tp) {
      int loops = tp.loops * reps;
      int listSize = list.size();
      for(int i = 0; i < loops; i++)
        list.get(rand.nextInt(listSize));
      return loops;
} });
  


qTests.add(new Test<StringContainer>("insert") {
int test(StringContainer list, TestParam tp) {
  int loops = tp.loops;
  for(int i = 0; i < loops; i++)
    list.insert(5, "47"); // Minimize random-access cost
  return loops;
} });
		
		
		
		
		  }
		  
		  
		  static class ListTester extends Tester<List<String>> {
			  public ListTester(List<String> container,
			      List<Test<List<String>>> tests) {
			    super(container, tests);
			  }
			  // Fill to the appropriate size before each test:
			  @Override protected List<String> initialize(int size){
			    container.clear();
			    container.addAll(CollectionData.list(new RandomGenerator.String(), size));
			    return container;
			  }
			  // Convenience method:
			  public static void run(List<String> list,
			      List<Test<List<String>>> tests) {
			    new ListTester(list, tests).timedTest();
			} }
		  
		  

		 	  
		  
		  
	public static void main(String[] args) {
		
			ListTester.run(new ArrayList<String>(), tests);
		    ListTester.run(new LinkedList<String>(), tests);
		    ListTester.run(new StringContainer(), qTests);
		    ListTester.run(new StringContainer(), tests);
		  
	}

}
