package com.learning.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/prompts")
public class PromptTemplateController {

    private final ChatClient chatClient;

    @Autowired
    public PromptTemplateController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Demonstrates dynamic Prompt Templating in Spring AI
     * Example: GET http://localhost:8080/api/v1/prompts/explain?topic=Kafka&audience=Junior Developer
     */
    @GetMapping("/explain")
    public String explainTopic(
            @RequestParam(defaultValue = "Event Sourcing with Kafka") String topic,
            @RequestParam(defaultValue = "Senior Java Lead") String audience) {

        String templateText = """
                You are a world-class tech mentor.
                Explain the following technical topic: {topic}.
                Tailor your explanation specifically for a {audience}.
                Focus on practical Java implementation, architecture patterns, and potential pitfalls.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(templateText);
        String renderedPrompt = promptTemplate.render(Map.of(
                "topic", topic,
                "audience", audience
        ));

        return chatClient.prompt()
                .user(renderedPrompt)
                .call()
                .content();
    }
}
