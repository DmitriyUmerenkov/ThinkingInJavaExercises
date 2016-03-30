package arrays;
import java.util.*;

public class Ex3to5 {
	static Random rand = new Random();
	static double[][] newDoubleArray(int dim1, int dim2, double minVal, double maxVal) {
		double[][] result=new double[dim1][dim2];
		for (int i=0;i<dim1;i++)
			for(int j=0;j<dim2;j++)
				result[i][j]=minVal+ rand.nextDouble()*(maxVal-minVal);
		return result;
		
	}
	static void printDoubleArray(double[][] toPrint) {
		System.out.println(Arrays.deepToString(toPrint));
		
		
	}
	
	static double[][][] newTripleArray(int dim1, int dim2, int dim3, double minVal, double maxVal) {
		double[][][] result=new double[dim1][dim2][dim3];
		for (int i=0;i<dim1;i++)
			for(int j=0;j<dim2;j++)
				for (int k=0;k<dim3;k++)
				result[i][j][k]=minVal+ rand.nextDouble()*(maxVal-minVal);
		return result;
		
	}
	static void printDoubleArray(double[][][] toPrint) {
		System.out.println(Arrays.deepToString(toPrint));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    printDoubleArray(newDoubleArray(2,3,0,1));
    printDoubleArray(newDoubleArray(2,1,0,10));
    printDoubleArray(newDoubleArray(3,2,-1,1));
    printDoubleArray(newTripleArray(2,3,1,0,1));
    printDoubleArray(newTripleArray(2,1,2,0,10));
    printDoubleArray(newTripleArray(3,2,1,-1,1));
	
    Ex3to5[][] testarray = new Ex3to5[2][3]; 
    System.out.println(Arrays.deepToString(testarray));
    
	}

}
