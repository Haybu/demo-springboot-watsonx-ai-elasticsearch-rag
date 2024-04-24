package io.agilehandy.watsonxai;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Haytham Mohamed
 * Date:   4/22/2024
 */

@ConfigurationProperties("app.watsonx.prompt")
@Data
@NoArgsConstructor
public class PromptProperties {

    private String instruction;
    private String userInput;
}
