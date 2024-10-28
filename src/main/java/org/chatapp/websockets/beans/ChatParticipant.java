package org.chatapp.websockets.beans;

import lombok.Data;

@Data
public class ChatParticipant {

    private String firstName;

    private String lastName;

    private String shortName;

    private String participantType;

}
