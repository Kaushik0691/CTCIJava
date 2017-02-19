
public class MergeSortImplementation {
	
	public void MergeSort(int[] A) {
	
		int size = A.length;
		if(size < 2)
			return; //Base case
		int mid = size/2;
		int[] left = new int[mid];
		int[] right = new int[size-mid];
		
		for(int i=0; i<mid; i++) {
			left[i] = A[i];
		}
		for(int i=mid; i<size; i++){
			right[i-mid] = A[i];
		}
		
		MergeSort(left);
		MergeSort(right);
		Merge(left,right, A);
	}
	
	public void Merge(int[] left, int[] right, int[] A) {
		int numLeft = left.length;
		int numRight = right.length;
		int i=0,j=0,k=0;
		
		while(i < numLeft && j < numRight) {
			if(left[i] < right[j]) {
				A[k] = left[i];
				i++;
			}
			else {
				A[k] = right[j];
				j++;
			}
			k++;
		}
		
		// Add left over elements from the left and right sub-arrays
		while(i < numLeft){
			A[k] = left[i];
			k++;
			i++;
		}
		
		while(j < numRight){
			A[k] = right[j];
			j++;
			k++;
		}
				
	}
	
	
	public static void main(String[] args) {
		
		MergeSortImplementation myObj = new MergeSortImplementation();
		int[] A = {1,3,4,2,9,5,7,6,8};
		System.out.println("Before Sorting");

		for(int i=0; i<A.length; i++)
			System.out.print(A[i] + " ");
		
		myObj.MergeSort(A);
		System.out.println();
		
		System.out.println("After Sorting");
		
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] + " ");

	}

}
