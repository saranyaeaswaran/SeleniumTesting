package allTests;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class CollectionsFramework {

	public static void main(String[] args) {
		AbstractCollection<Object> ac = new ArrayList<Object>();
		abstractCollection();
		collectionsClass();
		hashMapCheck();
		NoOfOccuranceUsingHashMap();
	}

	private static void NoOfOccuranceUsingHashMap() {
		System.out.println("####### duplicates in array check #########");
		int noArray[] = {10,20,10,20,30,40,30,30,30};

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 
		
		for(int i=0;i<noArray.length;i++) {		
			Integer count=hmap.get(noArray[i]);
			if(hmap.get(noArray[i])==null) {
				hmap.put(noArray[i], 1);
			}
			else {
				hmap.put(noArray[i], ++count);
			}
		}
		
		for(Map.Entry m:hmap.entrySet()) {
			System.out.println("Key is : "+m.getKey()+" and value is :"+m.getValue());
		}
		
		
		
	}

	private static void hashMapCheck() {
		System.out.println("####### hashMapCheck #########");
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "String 1");
		hm.put("2", "String 2");
		hm.put("3", "String 3");
		hm.put("4", "String 4");
		
//		System.out.println(hm.get("3"));
		for(String key:hm.keySet()) {
			System.out.println(hm.get(key));
		}
		
		
		
		
	}

	private static void abstractCollection() {
		System.out.println("####### abstractCollection #########");
		AbstractCollection<Object> ac = new ArrayList<Object>();
		ac.add("string 1");
		ac.add("string 2");
		System.out.println(ac);
		System.out.println(ac.contains("string 3"));	
	}

	private static void collectionsClass() {
		System.out.println("####### collectionsClass #########");
		List<String>  list = new ArrayList<String>();
		list.add("10");
		list.add("40");
		list.add("50");
		list.add("20");
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.rotate(list, 1);
		System.out.println(list);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		Collections.sort(list);
		System.out.println(list);	
		
		Iterator itr = list.iterator();
		ListIterator li=list.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());			
		}
		
		while(itr.hasNext()) {
				String str = (String) itr.next();
				System.out.println(str);
				
		}		
		System.out.println(list);	
		
	}

}
