package chapter3;

public class Ex10 {

	public static void main(String[] args) {

	int[] First= new int[2];
	int[] Second=new int[2];
	int[] Result=new int[4];
		
		for (int i=10;i<100;i++) {
			for (int j=i;j<100;j++) {
				if ((i*j)%100==0 || i*j<1000) continue;	

				First[1]=i%10;
				First[0]=i/10;
				Second[1]=j%10;
				Second[0]=j/10;
				Result[3]=(i*j)%10;
				Result[2]=((i*j)%100-Result[3])/10;
				Result[1]=((i*j)%1000-Result[2]*10-Result[3])/100;
				Result[0]=(i*j)/1000;			
			

/*				System.out.print(First[0]);
				System.out.print(First[1]+ " ");
				System.out.print(Second[0]);
				System.out.print(Second[1] + " ");
				System.out.println();					
	*/			
				for (int i1=0;i1<4;i1++) {
					if (Result[i1]==Second[0])
					{
						Result[i1]=Result[i1]-10;
						Second[0]=Second[0]-10;
						continue;
					}
					if (Result[i1]==Second[1])
					{
						Result[i1]=Result[i1]-10;
						Second[1]=Second[1]-10;
						continue;
					}
					if (Result[i1]==First[0])
					{
						Result[i1]=Result[i1]-10;
						First[0]=First[0]-10;
						continue;
					}
					if (Result[i1]==First[1])
					{
						Result[i1]=Result[i1]-10;
						First[1]=First[1]-10;
						continue;
					}
				}
				
				if (Result[0]<0 && Result[1]<0 && Result[2]<0 && Result[3]<0)
				{
	
					System.out.print(10+First[0]);
					System.out.print(10+First[1]+ " ");
					System.out.print(10+Second[0]);
					System.out.print(10+Second[1] + " ");
					
					System.out.print(10+Result[0]);
					System.out.print(10+Result[1]);
					System.out.print(10+Result[2]);
					System.out.print(10+Result[3]);
					System.out.println();					
					
				}
				
			}
		}
		
	}

}
