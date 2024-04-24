package io.agilehandy.watsonxai;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.watsonx.WatsonxAiChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Author: Haytham Mohamed
 * Date:   4/22/2024
 */

@Service
public class WatsonxService {

    private final WatsonxAiChatClient chatClient;

    public WatsonxService(WatsonxAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Flux<ChatResponse> stream(Prompt prompt) {
        return chatClient.stream(prompt);
    }

    public Flux<ChatResponse> streamChatResponse(InputPrompt inputPrompt) {
        SystemMessage systemMessage = new SystemMessage(inputPrompt.getInstruction());
        UserMessage userMessage = new UserMessage(inputPrompt.getUserInput());
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        return chatClient.stream(prompt);
    }

    public Flux<String> streamString(InputPrompt inputPrompt) {
        return this.streamChatResponse(inputPrompt)
                .map(response -> response.getResult().getOutput().getContent());
    }
}
