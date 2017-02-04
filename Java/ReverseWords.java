// Program to reverse the words in a sentence.

public class ReverseWords {

	public static void Reverse(String s) {
		
		StringBuilder myString = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		String[] arr = s.split(" ");
		
		
		for(String myStr : arr) {
			temp.append(myStr);
			temp.reverse();
			myString.append(temp.toString());
			myString.append(" ");
			temp.delete(0, temp.length());
		}
		
		System.out.print(myString.toString());
	}
	
	public static void main(String[] args) {
		
			Reverse("The quick brown fox jumped over the lazy dog");
	}

}
