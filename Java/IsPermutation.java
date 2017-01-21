import java.util.Arrays;

public class IsPermutation {

	public static void main(String[] args) {
		String a = "yelloW";
		String b = "Weloyl";
		
		System.out.println(isPermutation(a,b));
		

	}
	
	static boolean isPermutation(String a, String b){
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		
		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);
		
		a = new String (charArrayA);
		b = new String (charArrayB);
		
		if(a.compareTo(b) == 0)
			return true;
		
		else
			return false;
		
		
	}
}
