
public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Numbers = {10, 77, 10, 54, -11, 10};
		int i;
		int total = 0;
	
		for (i=0; i<=(Numbers.length-1); i++)
		{
			if (Numbers[i]==10) {
					
				total = total+Numbers[i];
				if (total == 30)
				{
					System.out.println("the sum of the 10s in the array is " +total);
					break;
				
				}
					
				
			}
			
					
		}
		
	}

}
