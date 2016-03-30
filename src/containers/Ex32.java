package containers;

import util.*;
import java.util.*;

import containers.ListPerformance.ListTester;



class IntegerContainer extends AbstractList<Integer> 
{
	public void clear() {data=new int[10];index=0;}
	
	
	IntegerContainer() {super(); data=new int[10];}
	IntegerContainer(int size) {super(); data=new int[size];}
	
	int[] data;
	int index;
	
	private void resize()
	{	
	 if (index==data.length) 
	{
		int[] newdata = new int[data.length+data.length/2]; 
		for (int i=0;i<data.length;i++) 
			newdata[i]=data[i];
		data=newdata;
	}
	
}
	void add(int i) 
	{
	resize();
	data[index++]=i;
	}
	
	
	void set(int position, int i) 
	{
	data[position]=i;
	}

	public Integer get(int position) {return data[position];}
	
	void insert(int position, int in) {
	resize();
	  for (int i=data.length-1;i>=position;i--)
		  data[i]=data[i-1];
	 data[position]=in;
	 index++;
	}
	
	
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
						
			int itpos=-1;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (itpos<index-1);
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return data[++itpos];
			}
			public void add(int i ) {
				
			insert(++itpos,i);	
				
				
			}
		
		
		};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.length;
	}
}




public class Ex32 {
	
	static List<Test<List<Integer>>> tests =
		    new ArrayList<Test<List<Integer>>>();
	
		  static List<Test<IntegerContainer>> qTests =
		    new ArrayList<Test<IntegerContainer>>();
		  
		  static Random rand=new Random();
		  
		  public static TestParam[] defaultParams= TestParam.array(
				    10, 5000, 100, 5000, 1000, 5000, 10000, 500);
		  static int reps = 1000;
		  
		  static {

			    tests.add(new Test<List<Integer>>("add") {
				      int test(List<Integer> list, TestParam tp) {
				        int loops = tp.loops;
				        int listSize = tp.size;
				        for(int i = 0; i < loops; i++) {
				          list.clear();
				          for(int j = 0; j < listSize; j++)
				            list.add(j);
				        }
				        return loops * listSize;
				      }
				    });
			  
		    
		    tests.add(new Test<List<Integer>>("get") {
		      int test(List<Integer> list, TestParam tp) {
		        int loops = tp.loops * reps;
		        int listSize = list.size();
		        for(int i = 0; i < loops; i++)
		          list.get(rand.nextInt(listSize));
		        return loops;
		} });
		    
	    

		tests.add(new Test<List<Integer>>("insert") {
		  int test(List<Integer> list, TestParam tp) {
		    int loops = tp.loops;
		    for(int i = 0; i < loops; i++)
		      list.add(5, 47); // Minimize random-access cost
		    return loops;
		} });
	
	    tests.add(new Test<List<Integer>>("increment") {
		      int test(List<Integer> list, TestParam tp) {
		        int loops = tp.loops;
		        int listSize = tp.size;
		        //int val;
		        for(int i = 0; i < loops; i++) {
		          for(int j = 0; j < listSize; j++)
		        	  list.set(j, list.get(j)+1);  
		        	  
		        }
		        return loops * listSize;
		      }
		    });
		
		
	    qTests.add(new Test<IntegerContainer>("add") {
		      int test(IntegerContainer list, TestParam tp) {
		        int loops = tp.loops;
		        int listSize = tp.size;
		        for(int i = 0; i < loops; i++) {
		          list.clear();
		          for(int j = 0; j < listSize; j++)
		            list.add(j);
		        }
		        return loops * listSize;
		      }
		    });
	  
  
  qTests.add(new Test<IntegerContainer>("get") {
    int test(IntegerContainer list, TestParam tp) {
      int loops = tp.loops * reps;
      int listSize = list.size();
      for(int i = 0; i < loops; i++)
        list.get(rand.nextInt(listSize));
      return loops;
} });
  


qTests.add(new Test<IntegerContainer>("insert") {
int test(IntegerContainer list, TestParam tp) {
  int loops = tp.loops;
  for(int i = 0; i < loops; i++)
    list.insert(5, 47); // Minimize random-access cost
  return loops;
} });

qTests.add(new Test<IntegerContainer>("increment") {
    int test(IntegerContainer list, TestParam tp) {
      int loops = tp.loops;
      int listSize = tp.size;
      for(int i = 0; i < loops; i++) {
       for(int j = 0; j < listSize; j++)
      	  list.set(j, list.get(j)+1);  
      }
      return loops * listSize;
    }
  });
		
		
		
		
		  }
		  
		  
		  static class ListTester extends Tester<List<Integer>> {
			  public ListTester(List<Integer> container,
			      List<Test<List<Integer>>> tests) {
			    super(container, tests);
			  }
			  // Fill to the appropriate size before each test:
		//	  @Override protected List<Integer> initialize(int size){
		//	    container.clear();
		//	    container.addAll(CollectionData.list(new RandomGenerator.Integer(), size));
		//	    return container;
		//	  }
			  // Convenience method:
			  public static void run(List<Integer> list,
			      List<Test<List<Integer>>> tests) {
			    new ListTester(list, tests).timedTest();
			} }
		  
		  

		 	  
		  
		  
	public static void main(String[] args) {
		
			ListTester.run(new ArrayList<Integer>(), tests);
	//	    ListTester.run(new LinkedList<Integer>(), tests);
		    ListTester.run(new IntegerContainer(), qTests);
	
	}

}
