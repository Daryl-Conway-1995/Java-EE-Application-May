package util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
public class JsonConverter {
	
	private Gson gson;
	
	public JsonConverter()
	{
		this.gson = new Gson();
	}
	
	public String objectConvert(Object obj) {
		return gson.toJson(obj);
	}

	
	public <T> T jsonConvert(String jsonString, Class<T> list) {
		return gson.fromJson(jsonString, (Type) list);
	}
}
