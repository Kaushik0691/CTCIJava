// Code to replace adjacent digits with the larger digit (of the 2) and find the minimum among all the numbers that are formed this way.

// e.g.  65436 -> 6436, 6536, 6546; Minimum -> 6436; Print 6436.


public class NumberManip {
	
	public static int FindMin(int num) {
		int min = Integer.MAX_VALUE;
		String tempString = Integer.toString(num);
		String minString = "";
		int tempVal;
		
		
		for(int i=0; i<tempString.length()-1; i++) {
			minString = "";
			if(tempString.charAt(i) > tempString.charAt(i+1)) {
				minString += tempString.substring(0,i+1);
				minString += tempString.substring(i+2, tempString.length());
			}
			
			else {
				minString += tempString.substring(0,i);
				minString += tempString.substring(i+1, tempString.length());
			}
			
			tempVal = Integer.valueOf(minString);
			if(tempVal < min)
				min = tempVal;
		}
		
		return min;
	}

	public static void main(String[] args) {
		
		System.out.println(FindMin(233614));
		System.out.println(FindMin(65436));
			
	}

}

