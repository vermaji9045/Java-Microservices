package com.bank.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}


	@Bean
	public RouteLocator publicBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder)
	{

return routeLocatorBuilder.routes()
		.route(p-> p
				 .path("/publicbank/accounts/**")
				.filters(f->f.rewritePath("/publicbank/accounts/(?<segment>.*)","/${segment}"))
				.uri("lb://ACCOUNTS"))

		.route(p-> p
				.path("/publicbank/cards/**")
				.filters(f->f.rewritePath("/publicbank/cards/(?<segment>.*)","/${segment}"))
				.uri("lb://CARDS"))
		.route(p-> p
				.path("/publicbank/loans/**")
				.filters(f->f.rewritePath("/publicbank/loans/(?<segment>.*)","/${segment}"))
				.uri("lb://LOANS")).build();
	}

}
