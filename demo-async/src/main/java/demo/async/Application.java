package demo.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import demo.async.function.AsyncConfig;

@SpringBootApplication
@EnableAsync
//@EnableConfigurationProperties({AsyncConfig.class} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
