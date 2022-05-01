package com.womakerscode.notification.controller.request;

import com.womakerscode.notification.model.EmailType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {

    private String email;

    private EmailType type;
}
