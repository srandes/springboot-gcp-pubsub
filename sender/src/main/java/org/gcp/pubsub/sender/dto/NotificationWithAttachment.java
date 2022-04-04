package org.gcp.pubsub.sender.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class NotificationWithAttachment {
    private String phoneNumber;
    private String encodeFile;
}
