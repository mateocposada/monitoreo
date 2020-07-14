package co.com.telematica.monitoreo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MonitoreoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoreoApplication.class, args);
	}

}
