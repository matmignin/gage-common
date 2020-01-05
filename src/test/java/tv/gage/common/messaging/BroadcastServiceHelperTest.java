package tv.gage.common.messaging;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tv.gage.common.game.Player;

public class BroadcastServiceHelperTest {

	private BroadcastServiceHelper broadcastServiceHelper = new BroadcastServiceHelper(
			new BroadcastService() {
				protected void sendPlayerMessage(Message message) {}
				protected void sendGameMessage(Message message) {}
			}, "SIMN");

	@Test
	public void broadcastToPlayerTest() {
		Player player = Player.builder().playerCode("PLYR").build();
		broadcastServiceHelper.broadcastToPlayer(player, "Test");
	}
	
	@Test
	public void broadcastToPlayersTest() {
		Player player1 = Player.builder().playerCode("PLYR").build();
		Player player2 = Player.builder().playerCode("WINR").build();
		List<Player> players = Arrays.asList(new Player[] {player1, player2});
		broadcastServiceHelper.broadcastToPlayers(players, "Test");
	}
	
	@Test
	public void broadcastToGameTest() {
		broadcastServiceHelper.broadcastToGame("Test");
	}

}
