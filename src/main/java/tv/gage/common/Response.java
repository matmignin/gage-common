package tv.gage.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	private Object result;
	private String error;
	
}
