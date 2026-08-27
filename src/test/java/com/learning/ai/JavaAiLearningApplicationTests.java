package com.learning.ai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.main.allow-bean-definition-overriding=true",
    "spring.ai.openai.api-key=test-key",
    "langchain4j.open-ai.chat-model.api-key=test-key"
})
class JavaAiLearningApplicationTests {

    @Test
    void contextLoads() {
        // Verifies Spring context initializes cleanly with AI starters
    }
}
