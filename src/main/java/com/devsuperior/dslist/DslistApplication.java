package com.devsuperior.dslist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DslistApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DslistApplication.class, args);
		
		SpringApplication app = new SpringApplication(DslistApplication.class);

	    Map<String, Object> props = new HashMap<>();
	    String port = System.getenv("PORT");
	    if (port != null) props.put("server.port", port);

	    app.setDefaultProperties(props);
	    app.run(args);
	    
	    System.out.println("🚀 API Spring Boot iniciada com sucesso!");
	    System.out.println("🔧 Perfil ativo: " + System.getenv("APP_PROFILE"));


		
	}

}
