package arrays;

import java.util.*;
import util.*;
import static util.Print.*;


class BerylliumGenerator implements Generator<BerylliumSphere> {
	public BerylliumSphere next() {return new BerylliumSphere();}
}



public class ContainerComparison {
	
	
	
	public static void main(String[] args) {
    BerylliumSphere[] spheres = Generated.array(BerylliumSphere.class, new BerylliumGenerator(),5);
    		/*new BerylliumSphere[10];
    for(int i = 0; i < 5; i++)
      spheres[i] = new BerylliumSphere(); */
    print(Arrays.toString(spheres));
    print(spheres[4]);
    List<BerylliumSphere> sphereList = 
    		new ArrayList<BerylliumSphere>(Arrays.asList(Generated.array(BerylliumSphere.class, new BerylliumGenerator(),5))); 
    /*  new ArrayList<BerylliumSphere>();
    for(int i = 0; i < 5; i++)
      sphereList.add(new BerylliumSphere());*/    
    print(sphereList);
    print(sphereList.get(4));
    int[] integers = { 0, 1, 2, 3, 4, 5 };
    print(Arrays.toString(integers));
    print(integers[4]);
    List<Integer> intList = new ArrayList<Integer>(
      Arrays.asList(0, 1, 2, 3, 4, 5));
    intList.add(97);
    print(intList);
    print(intList.get(4));
  }
}