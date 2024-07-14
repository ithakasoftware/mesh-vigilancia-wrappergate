package com.ithaka.ufabc.openwebcam;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class App {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(App.class, args);
	}
}