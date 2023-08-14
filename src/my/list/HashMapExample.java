package my.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		
		//객체 저장
		map.put("홍길동", 85);
		map.put("강길동", 75);
		map.put("이길동", 65);
		map.put("차길동", 55);
		map.put("서길동", 45);
		map.put("최길동", 35);
		map.put("박길동", 25);
		
		System.out.println("총 객체 수: "+map.size());
		System.out.println();
		
		//키로 값 얻기
		String key= "홍길동";
		int value = map.get(key);
		System.out.println(key+", "+value);
		System.out.println();
		
		//키를 반복해서 키와 값을 모두 얻기
		Set<String> keySet = map.keySet();
		
		Iterator<String> iterator= keySet.iterator();
		
		while(iterator.hasNext()) {
			String s= iterator.next();
			Integer v = map.get(s);
			
			System.out.println(s+":"+v);
			map.remove("홍길동");
			System.out.println(map.size());
			
			
			
		}
	}

}
