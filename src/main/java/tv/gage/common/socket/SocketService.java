package tv.gage.common.socket;

import tv.gage.common.messaging.Message;

public interface SocketService {

	void sendGameMessage(Message message);
	void sendPlayerMessage(Message message);
	
}
