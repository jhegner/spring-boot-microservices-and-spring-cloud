package br.com.jhegnerlabs.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppBootEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(AppBootEurekaServer.class, args);
	}

}
