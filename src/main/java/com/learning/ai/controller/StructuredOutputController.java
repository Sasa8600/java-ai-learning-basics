package com.learning.ai.controller;

import com.learning.ai.dto.CodeReviewResult;
import com.learning.ai.dto.MovieRecommendation;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.ParameterizedTypeReference;
import java.util.List;

@RestController
@RequestMapping("/api/v1/structured")
public class StructuredOutputController {

    private final ChatClient chatClient;

    @Autowired
    public StructuredOutputController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Demonstrates parsing LLM output directly into a Java Record (CodeReviewResult)
     */
    @PostMapping("/review-code")
    public CodeReviewResult reviewCode(@RequestBody String sourceCode) {
        String systemInstruction = """
                You are a Principal Java Architect. Analyze the provided Java code snippet for:
                1. Performance bottlenecks
                2. Security vulnerabilities
                3. Best practices (Clean Code, Spring Boot conventions)
                Provide a structured review report matching the requested schema.
                """;

        return chatClient.prompt()
                .system(systemInstruction)
                .user(sourceCode)
                .call()
                .entity(CodeReviewResult.class);
    }

    /**
     * Demonstrates returning a list of Java Records (List<MovieRecommendation>)
     */
    @GetMapping("/recommendations")
    public List<MovieRecommendation> getRecommendations(@RequestParam(defaultValue = "Sci-Fi thriller with mind-bending plots") String preference) {
        String prompt = "Recommend 3 movies matching the preference: " + preference;


        return chatClient.prompt()
                .user(prompt)
                .call()
                .entity(new ParameterizedTypeReference<List<MovieRecommendation>>() {});
    }
}
