package org.chatapp.websockets.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfig is a configuration class that sets up WebSocket messaging
 * support in a Spring application.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registers STOMP endpoints for WebSocket connections.
     *
     * This method adds a WebSocket endpoint that clients can use to connect
     * to the server. The endpoint "/runay-chat-app" is registered, and it
     * supports SockJS fallback options, which provide compatibility for
     * browsers that do not support WebSockets.
     *
     * The setAllowedOrigins("*") allows cross-origin requests from any
     * domain, which is useful during development. In production,
     * it is advisable to specify allowed origins for security.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/runay-chat-app").setAllowedOrigins("*").withSockJS();
    }

    /**
     * Configures the message broker for WebSocket communication.
     *
     * This method sets up the message broker to enable handling of messages
     * sent to destinations prefixed with "/topic". The enableSimpleBroker
     * method activates an in-memory message broker for broadcasting messages
     * to subscribers.
     *
     * The method also sets the application destination prefix to "/app",
     * which is used for messages that are routed to methods annotated with
     * @MessageMapping. This prefix helps distinguish between application
     * messages and topic messages.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}
