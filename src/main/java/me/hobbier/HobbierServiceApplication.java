package me.hobbier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lilit.abrahamyan
 */
@SpringBootApplication
@ImportResource("classpath:application-config.xml")
public class HobbierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbierServiceApplication.class, args);
	}
}
