package tv.gage.common.messaging;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tv.gage.common.game.Player;

public class BroadcastServiceTest {
	
	private BroadcastService broadcastService = new BroadcastService() {
		protected void sendPlayerMessage(Message message) {}
		protected void sendGameMessage(Message message) {}
	}; 

	@Test
	public void broadcastToPlayerTest() {
		Player player = Player.builder().playerCode("PLYR").build();
		broadcastService.broadcastToPlayer("SIMN", player, "Test");
	}
	
	@Test
	public void broadcastToPlayersTest() {
		Player player1 = Player.builder().playerCode("PLYR").build();
		Player player2 = Player.builder().playerCode("WINR").build();
		List<Player> players = Arrays.asList(new Player[] {player1, player2});
		broadcastService.broadcastToPlayers("SIMN", players, "Test");
	}
	
	@Test
	public void broadcastToGameTest() {
		broadcastService.broadcastToGame("SIMN", "Test");
	}

}
