import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapSort {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
			
		hmap.put(5, "A");
	    hmap.put(11, "C");
	    hmap.put(4, "Z");
	    hmap.put(77, "Y");
	    hmap.put(9, "P");
	    hmap.put(66, "Q");
	    hmap.put(0, "R"); 
	
	    System.out.println("Before sorting");
	    Set<Entry<Integer, String>> mySet = hmap.entrySet(); //Set of entries of HashMap.
	    
	    for(Entry<Integer, String> entry: mySet ) {
	    	System.out.print(entry.getKey() + ":");
	    	System.out.println(entry.getValue());
	    }
	    // Sorting by key.
	    
	    TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(hmap);
	    System.out.println("After sorting by key");
	    Set<Entry<Integer, String>> myTreeSet = tmap.entrySet();
	    for(Entry<Integer, String> entry : myTreeSet) {
	    	System.out.print(entry.getKey() + ":");
	    	System.out.println(entry.getValue());
	    }
	    
	    //Sorting by value.
	    // 1. Define Comparator to compare the values of the HashMap
	    // 2. Convert HashMap into list and invoke the Collections.sort function on this list using the Comparator created above.
	    // 3. After sorting, create a LinkedHashMap and insert the values of the sorted list into it. LinkedHashMap will preserve the order of insertion.
	    
	    Comparator<Entry<Integer, String>> myComparator= new Comparator<Entry<Integer, String>>() {
	    	
	    	@Override
	    	public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
	    		String v1 = e1.getValue();
	    		String v2 = e2.getValue();
	    		
	    		return v1.compareTo(v2);
	    	}
	    };
	    
	    // Convert HashMap to list.
	    List<Entry<Integer, String>> myList = new ArrayList<Entry<Integer, String>>(mySet);
	    Collections.sort(myList, myComparator);
	    LinkedHashMap<Integer, String> sortedByValue = new LinkedHashMap<Integer, String>(myList.size());
	    //Insert the values into the LinkedHashMap
	    for(Entry<Integer, String> entry: myList) {
	    	sortedByValue.put(entry.getKey(), entry.getValue());	    	
	    }
	    //Display the values.
	    Set<Entry<Integer, String>> myEntries = sortedByValue.entrySet();
	    System.out.println("Sorted by values!");
	    for(Entry<Integer, String> entry: myEntries) {
	    	System.out.print(entry.getKey() + ":");
	    	System.out.println(entry.getValue());
	    }
	
	}
	
	
	
}
