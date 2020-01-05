package tv.gage.common.game;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class CodeGenerator {
	
	public String generateUniqueGameCode(List<Game> games) {
		String code = generate(4);
		if (!isGameCodeUnique(code, games)) {
			return generateUniqueGameCode(games);
		}
		return code;
	}
	
	private String generate(int size) {
		return RandomStringUtils.randomAlphabetic(size).toUpperCase();
	}
	
	private boolean isGameCodeUnique(String code, List<Game> games) {
		Game existingGameWithCode = games.stream()
				.filter(game -> game.getGameCode().equals(code))
				.findFirst()
				.orElse(null);
		return existingGameWithCode == null;
	}
	
	public String generateUniquePlayerCode(List<Player> players) {
		String code = generate(4);
		if (!isPlayerCodeUnique(code, players)) {
			return generateUniquePlayerCode(players);
		}
		return code;
	}
	
	private boolean isPlayerCodeUnique(String code, List<Player> players) {
		Player existingPlayerWithCode = players.stream()
				.filter(player -> player.getPlayerCode().equals(code))
				.findFirst()
				.orElse(null);
		return existingPlayerWithCode == null;
	}
	
}
