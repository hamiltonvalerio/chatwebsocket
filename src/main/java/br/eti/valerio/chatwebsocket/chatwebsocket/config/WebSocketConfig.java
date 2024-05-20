package br.eti.valerio.chatwebsocket.chatwebsocket.config;

import br.eti.valerio.chatwebsocket.chatwebsocket.controller.ChatController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatController chatController;

    public WebSocketConfig(ChatController chatController) {
        this.chatController = chatController;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatController, "/chat").setAllowedOrigins("*");
    }
}
