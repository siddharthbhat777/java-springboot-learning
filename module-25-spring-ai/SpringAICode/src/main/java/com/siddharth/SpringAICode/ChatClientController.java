package com.siddharth.SpringAICode;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatClientController {

    private ChatClient chatClient;
    private ChatMemory chatMemory;

    // Using ChatClient programmatically if you have multiple different models
    /*public ChatClientController(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }*/

    // Using ChatClient autoConfigured Builder if you have single model
    public ChatClientController(ChatClient.Builder builder) {
        this.chatMemory = MessageWindowChatMemory.builder().build();
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("/api/openai/chat/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        // String response = chatClient.prompt(message).call().content(); // getting LLM model response directly

        // More options using ChatResponse
        ChatResponse chatResponse = chatClient.prompt(message).call().chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText(); // same response but with different way with more options
        return ResponseEntity.ok(response);
    }
}
