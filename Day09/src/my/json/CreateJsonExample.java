package my.json;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) {
		//json 객체 생성
		JSONObject root = new JSONObject();
		
		// 속성 추가
		root.put("id", "writer");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);
		
		//객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("home", "042-931-8685");
		tel.put("mobile", "010-4658-8658");
		
		root.put("tel",tel);
		
		// 배열 속성 추가
		JSONArray skill =new JSONArray();
		skill.put("Java");
		skill.put("C");
		skill.put("C++");
		skill.put("JavaScript");
		
		root.put("skill", skill);
		
		//JSON 객체 얻기
		String json = root.toString();
		
		
		//콘솔로 출력하기
		System.out.println(json);
		
		//파일로 저장하기
		try {
			Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
			writer.write(json);
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	
}
