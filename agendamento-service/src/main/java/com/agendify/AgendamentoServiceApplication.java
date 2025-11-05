package com.agendify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.agendify")
public class AgendamentoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoServiceApplication.class, args);
	}
}
