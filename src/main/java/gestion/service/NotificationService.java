/*package gestion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import gestion.dto.ResponseMessageDTO;


@Service
public class NotificationService {
	
	@Autowired
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendGlobalNotification() {
        ResponseMessageDTO message = new ResponseMessageDTO("Global Notification");

        messagingTemplate.convertAndSend("/topic/global-notifications", message);
    }

    public void sendPrivateNotification(final String userId) {
        ResponseMessageDTO message = new ResponseMessageDTO("Private Notification");

        messagingTemplate.convertAndSendToUser(userId,"/topic/private-notifications", message);
    }
}*/