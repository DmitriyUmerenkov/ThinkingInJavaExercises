package chapter3;

public class Ex6 {

	static int result = 0;

	static void test(int testval, int begin, int end) {
	 if(testval < begin || testval > end)
	 result = -1;
	 else if(testval < end && testval > begin)
	 result = +1;
	 else
	 result = 0; // Match
	 } 
	
	 static int test2(int testval, int begin, int end) {
		 if(testval < begin || testval > end)
			 return -1;
			 else if(testval < end && testval > begin)
			 return +1;
			 else
			 return 0; // Match		 } 
	 }
	
	public static void main(String[] args) {
		test(5,1,10);
		System.out.println("5,1,10 "+  result);
		test(5,8,10);
		System.out.println("5,8,10 "+  result);
		test(7,1,10);
		System.out.println("7,1,10 "+  result);
		test(10,1,10);
		System.out.println("10,1,10 "+  result);

		System.out.println("");

		System.out.println("5,1,10 "+  test2(5,1,10));
		System.out.println("5,8,10 "+  test2(5,8,10));
		System.out.println("7,1,10 "+  test2(7,1,10));
		System.out.println("10,1,10 "+  test2(10,1,10));

	
	
	}

}
