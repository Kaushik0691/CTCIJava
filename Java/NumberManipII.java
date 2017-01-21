// Code to replace adjacent digits with the average of the 2 and find the maximum among all the numbers that are formed this way.

public class NumberManipII {
	
	public static int findMax(int num) {
		int max = Integer.MIN_VALUE;
		String tempString = Integer.toString(num);
		String maxString = "";
		int tempVal;
		for(int i = 0 ; i < tempString.length() - 1; i++) {
			maxString = "";
			maxString += tempString.substring(0, i);
			maxString += Math.round((float)(Integer.parseInt(String.valueOf(tempString.charAt(i))) + Integer.parseInt(String.valueOf(tempString.charAt(i+1)))) / 2);
			maxString += tempString.substring(i+2, tempString.length());
			
			tempVal = Integer.valueOf(maxString);
			if(tempVal > max)
				max = tempVal;
		}
		
		
		
		return max;
	}
	
	
	
	
	
	public static void main(String args[]) {
		
		
		System.out.println(findMax(65436));
		
	
	}
}

