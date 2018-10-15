package org.harman;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"org.harman"})
//@EnableAutoConfiguration
//@EnableJpaRepositories("org.harman.repository")
public class SpringBootRestApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	

}
