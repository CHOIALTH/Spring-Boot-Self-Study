package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	// main 메서드를 실행하면 @SpringBootApplication을 통해 실행됨
	// Spring Boot는 Tomcat이라는 web server을 내장하고 있음
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
