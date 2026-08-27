package com.learning.ai.dto;

public record ChatResponse(
        String reply,
        String modelUsed,
        long responseTimeMs,
        Integer promptTokens,
        Integer completionTokens
) {}
