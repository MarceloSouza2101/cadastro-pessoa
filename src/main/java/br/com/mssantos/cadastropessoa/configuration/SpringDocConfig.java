package br.com.mssantos.cadastropessoa.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

	// http://localhost:8080/swagger-ui/index.html
	@Bean
	public GroupedOpenApi swagger() {
		return GroupedOpenApi.builder()
				.group("br.gov.sp.prodesp.saa")
				.packagesToScan("br.com.mssantos.cadastropessoa.controller")
				.build();
	}
}
