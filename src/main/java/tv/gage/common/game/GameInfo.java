package tv.gage.common.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameInfo {

	private Class<?> clazz;
	private int minNumberOfPlayers;
	private int maxNumberOfPlayers;
	
	@JsonProperty("class")
	public String getClazz() {
		return clazz.getSimpleName();
	}

}
