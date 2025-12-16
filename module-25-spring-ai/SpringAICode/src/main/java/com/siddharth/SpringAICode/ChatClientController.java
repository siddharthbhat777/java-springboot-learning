package com.siddharth.SpringAICode;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ChatClientController {

    private ChatClient chatClient;
    // private ChatMemory chatMemory;
    @Autowired
    @Qualifier("openAiEmbeddingModel")
    private EmbeddingModel embeddingModel;

    // Using ChatClient programmatically if you have multiple different models
    public ChatClientController(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    // Using ChatClient autoConfigured Builder if you have single model
    /*public ChatClientController(ChatClient.Builder builder) {
        this.chatMemory = MessageWindowChatMemory.builder().build();
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }*/

    @GetMapping("/api/openai/chat/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        // String response = chatClient.prompt(message).call().content(); // getting LLM model response directly

        // More options using ChatResponse
        ChatResponse chatResponse = chatClient.prompt(message).call().chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText(); // same response but with different way with more options
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/recommend")
    public String recommend(@RequestParam String type, @RequestParam String year, @RequestParam String lang) {
        String tempt = """
                I want to watch a {type} movie tonight with good rating,
                looking for movies around this year {year}.
                The language I am looking for is {lang}.
                Suggest one specific movie and tell me the cast and length of the movie.
                
                response format should be:
                1. Movie Name
                2. basic plot
                3. cast
                4. length
                5. IMDB rating
                """;
        PromptTemplate promptTemplate = new PromptTemplate(tempt);
        Prompt prompt = promptTemplate.create(Map.of("type", type, "year", year, "lang", lang));

        String response = chatClient
                .prompt(prompt)
                .call()
                .content();

        return response;
    }

    @PostMapping("/api/embeddings")
    public float[] embeddings(@RequestParam String text) {
        return embeddingModel.embed(text);
    }
}
