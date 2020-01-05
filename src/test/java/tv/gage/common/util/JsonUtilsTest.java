package tv.gage.common.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonUtilsTest {

	@Test
	public void classInstantiationTest() {
		JsonUtils jsonUtils = new JsonUtils();
		assertEquals(JsonUtils.class, jsonUtils.getClass());
	}
	
	@Test
	public void jsonToObjectTest() throws JsonParseException, JsonMappingException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"description\":\"Test Pojo\",");
		sb.append("\"numbers\":[5, 10]");
		sb.append("}");
		TestPojo testPojo = (TestPojo) JsonUtils.jsonToObject(sb.toString(), TestPojo.class);
		assertEquals(testPojo.getDescription(), "Test Pojo");
		assertEquals(testPojo.getNumbers().length, 2);
		assertEquals(new Integer(5), testPojo.getNumbers()[0]);
		assertEquals(new Integer(10), testPojo.getNumbers()[1]);
	}
	
	@Test
	public void objectToJsonTest() throws JsonProcessingException {
		String expected = "{\"description\":\"Unit test\",\"numbers\":[1,2,3]}";
		TestPojo testPojo = TestPojo.builder()
				.description("Unit test")
				.numbers(new Integer[] {1, 2, 3})
				.build();
		String json = JsonUtils.ObjectToJson(testPojo);
		assertEquals(expected, json);
	}

}
