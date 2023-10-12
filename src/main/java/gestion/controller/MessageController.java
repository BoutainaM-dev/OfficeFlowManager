/*package gestion.controller;

import gestion.dto.MessageDTO;
import gestion.dto.ResponseMessageDTO;
import gestion.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class MessageController {
    @Autowired
    private NotificationService notificationService;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessageDTO getMessage(final MessageDTO message) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendGlobalNotification();
        return new ResponseMessageDTO(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public ResponseMessageDTO getPrivateMessage(final MessageDTO message,
                                             final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotification(principal.getName());
        return new ResponseMessageDTO(HtmlUtils.htmlEscape(
                "Sending private message to user " + principal.getName() + ": "
                        + message.getMessageContent())
        );
    }
}*/
