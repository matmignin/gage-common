package tv.gage.common.messaging;

import java.util.List;

import tv.gage.common.game.Player;

public abstract class BroadcastService {
	
	protected abstract void sendGameMessage(Message message);
	protected abstract void sendPlayerMessage(Message message);
	
	public void broadcastToPlayer(String gameCode, Player player, Object payload) {
		Message message = Message.builder()
				.gameCode(gameCode)
				.player(player)
				.payload(payload)
				.build();
		sendPlayerMessage(message);
	}
	
	public void broadcastToPlayers(String gameCode, List<Player> players, Object payload) {
		Message message = Message.builder()
				.gameCode(gameCode)
				.players(players)
				.payload(payload)
				.build();
		sendPlayerMessage(message);
	}
	
	public void broadcastToGame(String gameCode, Object payload) {
		Message message = Message.builder()
				.gameCode(gameCode)
				.payload(payload)
				.build();
		sendGameMessage(message);
	}

}
