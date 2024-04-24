package io.agilehandy.watsonxai;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Haytham Mohamed
 * Date:   4/22/2024
 */

@Data
@NoArgsConstructor
public class InputPrompt {

    private String instruction;

    @JsonProperty("user-input")
    private String userInput;
}
