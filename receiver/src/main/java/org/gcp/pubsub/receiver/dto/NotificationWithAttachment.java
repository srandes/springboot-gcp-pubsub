package org.gcp.pubsub.receiver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class NotificationWithAttachment {
    private String phoneNumber;
    private String encodeFile;
}
