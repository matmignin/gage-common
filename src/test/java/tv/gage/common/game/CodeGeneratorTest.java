package tv.gage.common.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import tv.gage.common.exception.PlayerRosterFullException;
import tv.gage.common.messaging.BroadcastService;
import tv.gage.common.messaging.Message;

public class CodeGeneratorTest {
	
	private List<Game> generateGames() throws PlayerRosterFullException {
		List<Game> games = new ArrayList<Game>();
		for (int i = 0; i < 5000; i++) {
			String gameCode = new CodeGenerator().generateUniqueGameCode(games);
			BroadcastService broadcastService = new BroadcastService() {
				protected void sendPlayerMessage(Message message) {}
				protected void sendGameMessage(Message message) {}
			};
			games.add(new TestGame(broadcastService, gameCode));
		}
		return games;
	}
	
	private List<Player> generatePlayers() {
		List<Player> players = new ArrayList<Player>();
		for (int j = 0; j < 5000; j++) {
			String playerCode = new CodeGenerator().generateUniquePlayerCode(players);
			players.add(Player.builder().playerCode(playerCode).build());
		}
		return players;
	}
	
	@Test
	public void gameCodeGeneratorTest() throws PlayerRosterFullException {
		List<Game> games = generateGames();
		List<String> uniqueGameCodes = games.stream()
				.map(game -> game.getGameCode())
				.distinct()
				.collect(Collectors.toList());
		assertEquals(games.size(), uniqueGameCodes.size());
	}
	
	@Test 
	public void playerCodeGeneratorTest() throws PlayerRosterFullException {
		List<Player> players = generatePlayers();
		List<String> uniquePlayerCodes = players.stream()
				.map(player -> player.getPlayerCode())
				.distinct()
				.collect(Collectors.toList());
		assertEquals(players.size(), uniquePlayerCodes.size());
	}

}
