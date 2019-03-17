package com.robotyagi.photohackmeme;


import com.robotyagi.photohackmeme.controller.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class PhotohackMemeApplication {

	public static void main(String[] args) {
		/*ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(this);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}*/
		SpringApplication.run(PhotohackMemeApplication.class, args);
	}

}

