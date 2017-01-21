// Sum of all paths to an image file in a given file structure.
public class FileStructure {

	public static int PathLength(String S)
	{	int length = 0;
	
		
		
		return length;
	}
	
	public static void main(String[] args) {
	
		String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n   file1.txt\ndir2\n file.gif";
		
		System.out.println(s);
		int sum = 0, spaces = 0;
		
		String[] arr = s.split("\n");
		
		for(int i=arr.length-1; i>=0; i--) {
			String line = arr[i];
			
			if(line.contains(".gif") || line.contains(".jpeg")) {
				spaces = line.length() - line.trim().length();
			}
			
			 if(spaces > line.length()-line.trim().length() ){
	               sum += line.trim().length()+1;
	               spaces--;
	           }
	       }
			System.out.println(sum);
		}
         
	}


