package com.sripiranavan.spring.jms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingMessage implements Serializable {
    private static final long serialVersionUID = -89898989898989898L;
    private UUID id;
    private String message;
}
