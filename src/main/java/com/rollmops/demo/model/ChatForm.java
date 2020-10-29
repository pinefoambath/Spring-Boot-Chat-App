package com.rollmops.demo.model;

// This is a class we need to make so that we can hold the form data in a Java object
public class ChatForm {
    private String username;
    private String messageText;
    private String messageType;

    public String getUsername() { return username; }

    public void setUsername(String username) {this.username = username; }

    public String getMessageText() { return messageText; }

    public void setMessageText(String messageText) {this.messageText = messageText; }

    public String getMessageType() { return messageType; }

    public void setMessageType(String messageType) {this.messageType = messageType; }
}
