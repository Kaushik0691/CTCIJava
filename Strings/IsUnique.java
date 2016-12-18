import java.util.HashMap;

public class IsUnique {

	public static void main(String[] args) {
		
		String s = "Kaushik";
		System.out.println(isUniqueWithoutAdditionalDS(s));
	}
	
	static boolean isUnique (String s){
		boolean result = true;
		HashMap <Character, Integer> myMap = new HashMap <Character, Integer>();
		
		for(int i=0; i<s.length(); i++){
			if( myMap.get(s.charAt(i)) != null){
					result = false;
			}
			myMap.put(s.charAt(i), 1);
		}
		
		return result;
	}
	
	static boolean isUniqueWithoutAdditionalDS (String s){
		int checker = 0;
		for(int i=0; i<s.length(); i++){
			int val = s.charAt(i) - 'a';
			int result = 1 << val; // shift 1 val times to the left. Basically, set the specific bit in the 32 bit integer.
			if((result & checker) > 0) // If the bit is already set to 1, then result & checker will return 1 -> Duplicates.
				return false;
			checker = checker | result; // setting the particular character's bit to 1;
		}
			
		return true;
		
	}

}
