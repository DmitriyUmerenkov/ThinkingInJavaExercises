package strings;

import java.util.regex.*;
import java.util.*;

public class Groups {
 static public final String POEM =
 "Twas brillig, and the slithy toves\n" +
 "Did gyre and gimble in the wabe.\n" +
 "All mimsy were the borogoves,\n" +
 "And the mome raths outgrabe.\n\n" +
 "Beware the Jabberwock, my son,\n" +
 "The jaws that bite, the claws that catch.\n" +
 "Beware the Jubjub bird, and shun\n" +
 "The frumious Bandersnatch.";
 public static void main(String[] args) {

	 Set<String> s = new HashSet<String>();
	 Matcher m =
 Pattern.compile("(^|\\s)[a-z]+")
 .matcher(POEM);
 while(m.find()) 
	 s.add(m.group()); 
 
 System.out.println("Word count= " +s.size());
 
 }
}