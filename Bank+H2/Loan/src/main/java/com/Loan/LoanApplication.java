package com.Loan;

import com.Loan.DTO.LoasnContactDetails;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoasnContactDetails.class})

@OpenAPIDefinition
		(
				info = @Info(

						title = "Loans microservice REST API Documentation",
						description = "Public Bank Loans microservice REST API Documentation",
						version = "v1",
						contact = @Contact(
								name = "Sandeep",
								email = "sk9366026@gmail.com"
						),
						license = @License(
								name = "Apache 2.0"
						)
				),
				externalDocs = @ExternalDocumentation(
						description = "Public Bank Loans microservice REST API Documentation"

				)

		)
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
