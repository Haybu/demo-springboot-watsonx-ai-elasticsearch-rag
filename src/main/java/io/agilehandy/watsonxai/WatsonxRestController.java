package io.agilehandy.watsonxai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Author: Haytham Mohamed
 * Date:   4/22/2024
 */

@RestController
@Slf4j
public class WatsonxRestController {

    private final PromptProperties promptProperties;
    private final WatsonxService service;

    public WatsonxRestController(PromptProperties promptProperties, WatsonxService service) {
        this.promptProperties = promptProperties;
        this.service = service;
    }

    /**
     *
     * @param inputPrompt in the form f
     *     {'instruction': instruction, 'user-input': input}
     * @return
     */
    @PostMapping("/prompt/response")
    public Flux<ChatResponse> streamChatResponse(@RequestBody InputPrompt inputPrompt) {
        log.info("Calling stream ChatResponse controller POST function");
        return service.streamChatResponse(inputPrompt);
    }

    @PostMapping("/prompt/string")
    public Flux<String> streamString(@RequestBody InputPrompt inputPrompt) {
        log.info("Calling stream String controller POST function");
        return service.streamString(inputPrompt);
    }

    @GetMapping("/prompt/response")
    public Flux<ChatResponse> streamChatReponse() {
        log.info("Calling ChatReponse stream controller GET function");
        InputPrompt inputPrompt = new InputPrompt();
        inputPrompt.setInstruction(promptProperties.getInstruction());
        inputPrompt.setUserInput(promptProperties.getUserInput());
        return service.streamChatResponse(inputPrompt);
    }

    @GetMapping("/prompt/string")
    public Flux<String> streamChatString() {
        log.info("Calling string stream controller GET function");
        InputPrompt inputPrompt = new InputPrompt();
        inputPrompt.setInstruction(promptProperties.getInstruction());
        inputPrompt.setUserInput(promptProperties.getUserInput());
        return service.streamString(inputPrompt);
    }

}
