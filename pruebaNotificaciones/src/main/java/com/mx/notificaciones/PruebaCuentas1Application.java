package com.mx.notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PruebaCuentas1Application {

	public static void main(String[] args) {
		SpringApplication.run(PruebaCuentas1Application.class, args);
	}

}
