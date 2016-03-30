package arrays;
import java.util.*;

public class Ex6and7 {

	public static BerylliumSphere[][] twoBalls(int dim1, int dim2) {
		BerylliumSphere[][] result= new BerylliumSphere[dim1][dim2];
		for (int i=0; i<dim1;i++)
			for (int j=0;j<dim2;j++)
				result[i][j]=new BerylliumSphere();
		return result;
	}

	public static BerylliumSphere[][][] twoBalls(int dim1, int dim2,int dim3) {
		BerylliumSphere[][][] result= new BerylliumSphere[dim1][dim2][dim3];
		for (int i=0; i<dim1;i++)
			for (int j=0;j<dim2;j++)
				for(int k=0;k<dim3;k++)
				result[i][j][k]=new BerylliumSphere();
		return result;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(twoBalls(2,3)));
		System.out.println(Arrays.deepToString(twoBalls(2,3,5)));
		
	}
	
	
}
