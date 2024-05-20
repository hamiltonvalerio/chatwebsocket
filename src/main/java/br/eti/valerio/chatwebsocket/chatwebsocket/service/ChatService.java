package br.eti.valerio.chatwebsocket.chatwebsocket.service;

import br.eti.valerio.chatwebsocket.chatwebsocket.model.ChatMessage;
import br.eti.valerio.chatwebsocket.chatwebsocket.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatResponse handleMessage(ChatMessage message) {
          return new ChatResponse("Server response to: " + message.getContent());
    }
}
