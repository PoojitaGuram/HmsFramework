package sqlprctise;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readdatafromjason {

	public static void main(String[] args) throws IOException, ParseException {
	FileReader filepath = new FileReader(".\\src\\test\\resources\\data.json");
	JSONParser jsonp=new JSONParser();
	Object obj=jsonp.parse(filepath);
	
	JSONObject map=(JSONObject) obj;
	System.out.println(map.get("Url"));
	System.out.println(map.get("Username"));
	System.out.println(map.get("Password"));
	
	}
}
	


