package org.harman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.harman"})
public class ContentnegotiationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentnegotiationApplication.class, args);
	}
}
