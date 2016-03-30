package containers;
import java.util.*;
import util.*;


class TFCollectionInintializer {
	public static Collection<String> GetFile(String FileName) {
		return new TextFile(FileName);
		}
	}


public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> aList= new LinkedList<String>(TFCollectionInintializer.GetFile("TextFile.java"));
		System.out.println(aList);
		
	}

}
