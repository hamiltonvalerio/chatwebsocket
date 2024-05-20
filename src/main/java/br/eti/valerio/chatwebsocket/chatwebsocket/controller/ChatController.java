package br.eti.valerio.chatwebsocket.chatwebsocket.controller;

import br.eti.valerio.chatwebsocket.chatwebsocket.model.ChatMessage;
import br.eti.valerio.chatwebsocket.chatwebsocket.model.ChatResponse;
import br.eti.valerio.chatwebsocket.chatwebsocket.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ChatController extends TextWebSocketHandler {

    private final ChatService chatService;
    private final ObjectMapper objectMapper;

    public ChatController(ChatService chatService, ObjectMapper objectMapper) {
        this.chatService = chatService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Add session handling logic here
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
        ChatResponse response = chatService.handleMessage(chatMessage);
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        session.close(CloseStatus.SERVER_ERROR);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Add session closing logic here
    }
}
