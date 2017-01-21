
public class URLify {

	public static void main(String[] args) {
		
		String s = "Kaushik Varadha Rajan";
		URLifyInput(s);
	}

	static void URLifyInput(String s){
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		
		for(int i=0; i<sb.length(); i++){
			if(sb.charAt(i) == ' ')
			{	sb.setCharAt(i, '%');
				sb.setCharAt(i+1, '2');
				sb.setCharAt(i+2, '0');
			}
		}
		
		System.out.println(sb.toString());
	}
}
