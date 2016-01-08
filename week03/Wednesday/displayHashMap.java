package week03.Wednesday;

import java.util.Map;
import java.util.HashMap;

public class displayHashMap {

	
	public static String display(HashMap<? extends Object, ? extends Object> data) {
		String res = "{ ";
		for (Map.Entry<? extends Object, ? extends Object> entry: data.entrySet()) {
			res += String.format("%s: %s, " , entry.getKey().toString(), entry.getValue().toString()); 
		}
		res += "}";
		return res;
	}
	
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		System.out.println(displayHashMap.display(map));
	}

}
