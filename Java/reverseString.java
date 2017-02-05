// Reverse the string word by word. (Leetcode problem #151)
// Input: "the sky is blue"
// Output: "blue is sky the"

public class Solution {
    public String reverseWords(String s) {
        
         
        StringBuilder myString = new StringBuilder();
        String str = s.trim().replaceAll(" +", " ");
		String[] arr = str.split(" ");
		
		
		for(int i=arr.length-1; i>=0; i--) {
		   
			if( i!=0) {
			    myString.append(arr[i]);
			    myString.append(" ");  
			}
			
			else
			    myString.append(arr[i]);
			
			
			  
		  
		}
		
		return myString.toString();
        
    }
}