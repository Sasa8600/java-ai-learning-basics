package com.learning.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LangChainTest {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Test
    public void testGroq() {
        try {
            System.out.println("Result: " + chatLanguageModel.generate("Hi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
