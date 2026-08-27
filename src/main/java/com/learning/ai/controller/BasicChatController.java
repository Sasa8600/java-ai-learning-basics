package com.learning.ai.controller;

import com.learning.ai.dto.ChatRequest;
import com.learning.ai.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
public class BasicChatController {

    private final ChatClient chatClient;
    private final ChatModel chatModel;

    @Autowired
    public BasicChatController(ChatModel chatModel, ChatClient.Builder chatClientBuilder) {
        this.chatModel = chatModel;
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Simple GET endpoint to test fast AI prompt execution
     * Example: GET http://localhost:8080/api/v1/chat/simple?message=Explain microservices in 2 sentences
     */
    @GetMapping("/simple")
    public String simpleChat(@RequestParam(defaultValue = "Tell me a short joke about Java developers") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    /**
     * POST endpoint accepting structured ChatRequest
     */
    @PostMapping("/completion")
    public ChatResponse completeChat(@RequestBody ChatRequest request) {
        long startTime = System.currentTimeMillis();

        String systemPrompt = request.systemPrompt() != null ? request.systemPrompt() 
                : "You are an expert Java Technical Lead assistant. Provide concise, high-quality technical answers.";

        String reply = chatClient.prompt()
                .system(systemPrompt)
                .user(request.message())
                .call()
                .content();

        long elapsedTime = System.currentTimeMillis() - startTime;

        return new ChatResponse(
                reply,
                "openai/gpt-oss-120b",
                elapsedTime,
                null,
                null
        );
    }
}
