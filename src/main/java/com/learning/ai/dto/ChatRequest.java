package com.learning.ai.dto;

public record ChatRequest(
        String message,
        String systemPrompt,
        Double temperature
) {
    public ChatRequest {
        if (temperature == null) {
            temperature = 0.7;
        }
    }
}
