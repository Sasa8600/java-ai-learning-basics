## 🏗️ Project Architecture & Concepts Covered

```
java-ai-learning/
 ├── src/main/java/com/learning/ai/
 │    ├── JavaAiLearningApplication.java      # Spring Boot Main Application
 │    ├── controller/
 │    │    ├── BasicChatController.java       # Direct ChatClient completions
 │    │    ├── PromptTemplateController.java  # Dynamic System & User Prompt Templates
 │    │    ├── StructuredOutputController.java# LLM Output -> Java Record Mapping
 │    │    ├── StreamingChatController.java   # Real-time SSE / Flux Token Streaming
 │    │    └── LangChain4jDemoController.java # LangChain4j ChatLanguageModel Integration
 │    └── dto/
 │         ├── ChatRequest.java               # Chat Input DTO
 │         ├── ChatResponse.java              # Chat Output DTO
 │         ├── CodeReviewResult.java          # Java Code Audit Record (Structured Output)
 │         └── MovieRecommendation.java       # Recommendation Record (Structured Output)
 └── src/main/resources/
      └── application.yml                     # Spring AI & LangChain4j Configurations
```

---

## ⚡ API Endpoints to Test

### 1. Basic Chat (`ChatClient`)
- **Endpoint:** `GET /api/v1/chat/simple?message=Explain Kafka Partitioning`
- **POST Endpoint:** `POST /api/v1/chat/completion`
```json
{
  "message": "What is the role of Spring AI in modern enterprise applications?",
  "systemPrompt": "You are a Principal Architect.",
  "temperature": 0.7
}
```

### 2. Dynamic Prompt Engineering (`PromptTemplate`)
- **Endpoint:** `GET /api/v1/prompts/explain?topic=Event Driven Architecture&audience=Junior Developer`

### 3. Structured Output Parsing (Java Records)
- **POST Code Review:** `POST /api/v1/structured/review-code`
- **GET Movie Recommendations:** `GET /api/v1/structured/recommendations?preference=Action packed heist movies`

### 4. Token Streaming (`Server-Sent Events / WebFlux`)
- **Endpoint:** `GET /api/v1/stream/chat?prompt=Write a step by step guide to optimize Spring Boot startup time`

### 5. LangChain4j Integration
- **Endpoint:** `GET /api/v1/langchain4j/generate?prompt=Explain LangChain4j AI Services`

---

## ⚙️ How to Run

### Set API Key (OpenAI / Gemini API Key):
```bash
export OPENAI_API_KEY="your-actual-api-key"
```

### Run Spring Boot App:
```bash
mvn spring-boot:run -Dmaven.repo.local=./.m2/repository
```
App will start on: `http://localhost:8080`
