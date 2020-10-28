
abstract class Book{
		String title;
		
		abstract void SetTitle(String s);
		
		String getTitle() {
			return title;
		}
	}
	
	class MyBook extends Book{
		public void SetTitle(String s) {
			title = s;
		}
	}
	
public class Activity_Abstract_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String title ="As A man Thinketh";		
		MyBook Novel = new MyBook();
		Novel.SetTitle(title);
		System.out.println(Novel.getTitle());

	}

}
