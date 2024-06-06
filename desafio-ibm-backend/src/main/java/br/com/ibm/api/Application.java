package br.com.ibm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ibm.api.repository")
@EntityScan(basePackages = "br.com.ibm.entity.cliente")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
