// Leet code - License key formatting problem.

public class LicenseKeyFormatting {
	
	public static String licenseKeyFormatting(String S, int K) {
		
		StringBuilder sb = new StringBuilder();
		int charLen = 0;
		String retString;
		
		for(int i = S.length()-1; i>=0; i--) {
			
			if(S.charAt(i) != '-') {
				
				if(charLen > 0 && charLen % K == 0) {
					sb.append('-');
				}
				
				sb.append(S.charAt(i));
				charLen++;
			}
			
		}
		
		retString = sb.reverse().toString();
		return retString.toUpperCase();
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(licenseKeyFormatting("2-4A0r7-4k",3));
		
	}
	
	
}