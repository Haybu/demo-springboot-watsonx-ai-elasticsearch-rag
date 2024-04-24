package io.agilehandy.watsonxai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

/**
 * Author: Haytham Mohamed
 * Date:   4/22/2024
 */

@SpringBootApplication
@EnableConfigurationProperties(PromptProperties.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RestClient.Builder resultClientBuilder() {
		return RestClient.builder();
	}
}
