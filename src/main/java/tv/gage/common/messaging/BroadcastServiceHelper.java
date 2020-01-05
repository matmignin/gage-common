package tv.gage.common.messaging;

import java.util.List;

import lombok.Data;
import tv.gage.common.game.Player;

@Data
public class BroadcastServiceHelper {

	private BroadcastService broadcastService;
	private String gameCode;
	
	public BroadcastServiceHelper(BroadcastService broadcastService, String gameCode) {
		this.broadcastService = broadcastService;
		this.gameCode = gameCode;
	}
	
	public void broadcastToPlayer(Player player, Object payload) {
		broadcastService.broadcastToPlayer(gameCode, player, payload);
	}
	
	public void broadcastToPlayers(List<Player> players, Object payload) {
		broadcastService.broadcastToPlayers(gameCode, players, payload);
	}
	
	public void broadcastToGame(Object payload) {
		broadcastService.broadcastToGame(gameCode, payload);
	}
	
}
