/*package gestion.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendNotification")
    public void sendNotificationToUser(String userId, String message) {
        // Assuming userId is the unique identifier of the user
        String destination = "/user/" + userId + "/queue/notifications";
        messagingTemplate.convertAndSend(destination, message);
    }
}
*/