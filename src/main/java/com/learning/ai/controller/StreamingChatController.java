package com.learning.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/stream")
public class StreamingChatController {

    private final ChatClient chatClient;

    @Autowired
    public StreamingChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Streams LLM response token-by-token using Server-Sent Events (SSE) / Flux
     * Example: GET http://localhost:8080/api/v1/stream/chat?prompt=Write a comprehensive guide on Kafka Producer Tuning
     */
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestParam(defaultValue = "Explain Spring Boot Spring Security Filter Chain in detail") String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .stream()
                .content();
    }
}
