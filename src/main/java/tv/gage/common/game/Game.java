package tv.gage.common.game;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tv.gage.common.exception.PlayerRosterFullException;
import tv.gage.common.exception.UnknownPlayerException;
import tv.gage.common.messaging.BroadcastService;
import tv.gage.common.messaging.BroadcastServiceHelper;

@Data
public abstract class Game {

	protected Class<?> clazz;
	protected BroadcastServiceHelper broadcastServiceHelper;
	protected String gameCode;
	protected int minNumberOfPlayers;
	protected int maxNumberOfPlayers;
	protected List<Player> players = new ArrayList<Player>();
	
	public Game(Class<?> clazz, BroadcastService broadcastService, String gameCode, int minNumberOfPlayers, int maxNumberOfPlayers) {
		this.clazz = clazz;
		this.broadcastServiceHelper = new BroadcastServiceHelper(broadcastService, gameCode);
		this.gameCode = gameCode;
		this.minNumberOfPlayers = minNumberOfPlayers;
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}
	
	public void addPlayer(Player player) throws PlayerRosterFullException {
		if (players.size() == maxNumberOfPlayers) {
			throw new PlayerRosterFullException("Cannot add player, roster full");
		}
		players.add(player);
	}
	
	public void removePlayer(Player player) throws UnknownPlayerException {
		if (!players.contains(player)) {
			throw new UnknownPlayerException(String.format("Unknown Player Code %s for Game Code %s", player.getPlayerCode(), gameCode));
		}
		players.remove(player);
	}
	
	@JsonProperty("class")
	public String getClazz() {
		return clazz.getSimpleName();
	}
	
	public GameInfo gameInfo() {
		return GameInfo.builder()
				.clazz(clazz)
				.minNumberOfPlayers(minNumberOfPlayers)
				.maxNumberOfPlayers(maxNumberOfPlayers)
				.build();
	}
	
	public abstract void receiveGameCommand(String jsonCommand);
	public abstract void receivePlayerCommand(Player player, String jsonCommand);
	
}
