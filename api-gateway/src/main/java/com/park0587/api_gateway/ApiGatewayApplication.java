package com.park0587.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()

				// Product Management
				.route("inventory-manager-no-id", r -> r
						.path("/api/inventory")
						.and().method("GET", "POST")
						.uri("http://localhost:8181/api/inventory"))

				// inventory requests with ID
				.route("inventory-manager-with-id", r -> r
						.path("/api/inventory/**")
						.and().method("GET", "PUT", "DELETE")
						.filters(f ->
								f.rewritePath("/api/inventory/(?<ID>.*)", "/api/inventory/${ID}"))
						.uri("http://localhost:8181"))

				// Order Management
				.route("order-handler-order-no-id", r -> r
						.path("/api/orders")
						.and().method("GET", "POST")
						.uri("http://localhost:8282/api/orders"))

				// Order requests with ID
				.route("order-handler-order-with-id", r -> r
						.path("/api/orders/**")
						.and().method("GET", "PUT", "DELETE")
						.filters(f ->
								f.rewritePath("/api/orders/(?<ID>.*)", "/api/orders/${ID}"))
						.uri("http://localhost:8282"))

				// Customer Management
				.route("order-handler-customer-no-id", r -> r
						.path("/api/customers")
						.and().method("GET", "POST")
						.uri("http://localhost:8282/api/customers"))

				// Customer requests with ID
				.route("order-handler-customer-with-id", r -> r
						.path("/api/customers/**")
						.and().method("GET", "PUT", "DELETE")
						.filters(f -> f
								.rewritePath("/api/customers/(?<ID>.*)", "/api/customers/${ID}"))
						.uri("http://localhost:8282"))

				// Stock Information with ID
				.route("order-handler-stock-with-id", r -> r
						.path("/api/stock/**")
						.and().method("GET")
						.filters(f -> f
								.rewritePath("/api/stock/(?<ID>.*)", "/api/stock/${ID}"))
						.uri("http://localhost:8282"))

				// Final build command
				.build();


	}

}
