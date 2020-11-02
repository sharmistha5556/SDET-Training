import java.awt.print.Printable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Activity3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> hs=new HashSet<String>();
		hs.add("Ram");
		hs.add("Sham");
		hs.add("Jam");
		hs.add("Tim");
		hs.add("Tom");
		hs.add("Tintin");
		
		System.out.println("Size of the hashset: " +hs.size());
		hs.remove("Sham");
		hs.remove("Zing");
		
		System.out.println("Validate if Ting is present in the set: "+hs.contains("Ting"));
		System.out.println("The set contains :" +Arrays.asList(hs));
		

	}

}
