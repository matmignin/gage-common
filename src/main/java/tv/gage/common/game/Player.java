package tv.gage.common.game;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

	private String name;
	private int score;
	private String playerCode;
	private String gameCode;
	
}
