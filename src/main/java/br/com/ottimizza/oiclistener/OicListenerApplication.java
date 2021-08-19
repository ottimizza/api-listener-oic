package br.com.ottimizza.oiclistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OicListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OicListenerApplication.class, args);
	}

}
