package br.eti.valerio.chatwebsocket.chatwebsocket.model;

public class ChatResponse {
    private String response;

    public ChatResponse(String response) {
        this.response = response;
    }

    // Getters and setters

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
