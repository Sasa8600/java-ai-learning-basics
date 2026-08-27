package com.learning.ai.controller;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/langchain4j")
public class LangChain4jDemoController {

    private final ChatLanguageModel chatLanguageModel;

    @Autowired
    public LangChain4jDemoController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    /**
     * LangChain4j chat endpoint
     */
    @GetMapping("/generate")
    public String generateWithLangChain4j(@RequestParam(defaultValue = "Compare LangChain4j vs Spring AI for Enterprise Java apps") String prompt) {
        return chatLanguageModel.generate(prompt);
    }
}
