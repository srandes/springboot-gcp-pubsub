package org.gcp.pubsub.receiver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DiscordEvent {
    private String name;
    private String number;
    private String message;
    private String channel;    
}
