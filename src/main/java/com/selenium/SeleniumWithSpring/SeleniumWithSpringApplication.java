package com.selenium.SeleniumWithSpring;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class SeleniumWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumWithSpringApplication.class, args);
	}
}
