import java.util.LinkedList;	
import java.util.Queue;

public class Activity3_3A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			q.add(5);
		
			q.remove();
			System.out.println("Print the first number in the queue:" +q.peek());			
			System.out.println("Print the size of the queue:" +q.size());
			System.out.println("Print the updated queue:" +q);
		
		

	}

}
