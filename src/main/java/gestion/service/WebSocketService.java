/*package gestion.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;
    private final Map<String, String> userSessionMap;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.userSessionMap = new ConcurrentHashMap<>();
    }

    public void associateUserWithSession(String userId, String sessionId) {
        userSessionMap.put(userId, sessionId);
    }
}
*/