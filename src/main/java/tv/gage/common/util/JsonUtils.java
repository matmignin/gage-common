package tv.gage.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object jsonToObject(String json, Class clazz) 
			throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
    }
    
    public static String ObjectToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
    	return mapper.writeValueAsString(object);
    }

}
