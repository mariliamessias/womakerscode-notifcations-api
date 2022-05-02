package com.womakerscode.notification.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SendEmaillMessage {
    private String messageId;
    private String email;
    private String name;
    private String type;
    private String eventName;
}
