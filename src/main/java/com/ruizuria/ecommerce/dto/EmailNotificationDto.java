package com.ruizuria.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailNotificationDto {
    private String to;
    private String subject;
    private String body;
    private boolean hasTemplate;
}
