package org.chatapp.websockets.controller;

import org.chatapp.websockets.beans.ChatInMessage;
import org.chatapp.websockets.beans.ChatOutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * ChatController handles incoming chat messages and user typing updates.
 * This controller listens for STOMP messages sent by clients and routes
 * them to the appropriate message handling methods.
 */
@Controller
public class ChatController {

    /**
     * Handles incoming chat messages from clients.
     *
     * This method listens for messages sent to the "/guest-chat" destination.
     * When a message is received, it creates a ChatOutMessage object containing
     * the content of the incoming message and sends it to all subscribers of
     * the "/topic/guest-chats" destination.
     *
     * @MessageMapping annotation maps this method to the incoming message
     * destination.
     *
     * @SendTo annotation specifies that the return value will be sent to the
     * specified destination.
     */
    @MessageMapping("/guest-chat")
    @SendTo("/topic/guest-chats")
    public ChatOutMessage handleMessaging(ChatInMessage message) throws Exception {
        return new ChatOutMessage(message.getMessage());
    }

    @MessageMapping("/guest-update")
    @SendTo("/topic/guest-updates")
    public ChatOutMessage handleUserIsTyping(ChatInMessage message) throws Exception {
        return new ChatOutMessage("Someone is typing...");
    }
}
