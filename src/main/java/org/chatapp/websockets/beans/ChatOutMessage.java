package org.chatapp.websockets.beans;

import lombok.Data;

import java.util.Date;

@Data
public class ChatOutMessage {
    private String content;

    private String groupName;

    private Date timestamp;


    public ChatOutMessage(String content) {
        this.content = content;
    }
}
