import java.util.Arrays;

public class Activity4 {
	
	static void SortNumbers(int array[]){
		int i=1;
		int j=i-1;
		int temp;
		
		for(i=1;i<array.length;i++) {
		  
		  for(j=0; j<=i-1;j++) {
			  if (array[i]<array[j]) {
				  temp = array[i];
				  array[i]=array[j];
				  array[j]=temp;
				  
			  }
		  
		  }
		}
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers= {5,7,1,12,55,32,4,16};
		SortNumbers(numbers);
		System.out.println("Sorted numbers are" +Arrays.toString(numbers));
		
	}

}
