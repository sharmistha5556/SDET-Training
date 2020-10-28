	
import java.util.ArrayList;

public class Activity3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList=new ArrayList<String>();
		myList.add("Ram");
		myList.add("Sam");
		myList.add("Jam");
		myList.add("Tom");
		myList.add("Harry");
		
		for (String s:myList) {
			System.out.println("Name of candidates" +s);		
		}
		
		System.out.println("3rd name in the list" +myList.get(2));
		System.out.println("Does Tim exist in the list" +myList.contains("Tim"));
		System.out.println("Size of the Araay" +myList.size());
		
		myList.remove(2);
		System.out.println("Size of the Araay" +myList.size());
	}
}
	
