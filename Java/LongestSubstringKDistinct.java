import java.util.*;

// Leet code - Longest substring with at most K distinct characters

public class LongestSubstringKDistinct {
	
	public int lengthOfLongestSubstringKDistinct(String S, int k) {
		
		int max = 0;
		int left = 0;
		
		Map<Character,Integer> myMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<S.length(); i++) {
			
			char c = S.charAt(i);
			myMap.put(c, myMap.getOrDefault(c, 0) + 1); // If element is already present, increment it by one, else initialize it to 1.
			
			while(myMap.size() > k) {
				char leftChar = S.charAt(left);
				
				if(myMap.containsKey(leftChar)) {
					myMap.put(leftChar, myMap.get(leftChar) - 1);
					
					if(myMap.get(leftChar) == 0)
						myMap.remove(leftChar);
				}
				left++;
			}
			
			max = Math.max(max, i - left + 1);
		}
		
		
		return max;
	}
	
	
	
	public static void main(String[] args) {
		
		Test myObj = new Test();
		System.out.println(myObj.lengthOfLongestSubstringKDistinct("eceba", 2));
		
	}
}