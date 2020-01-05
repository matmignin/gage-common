package tv.gage.common.messaging;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import tv.gage.common.game.Player;

@Data
@Builder
public class Message {

	@Singular
	private List<Player> players;
	private String gameCode;
	private Object payload;
	
}
