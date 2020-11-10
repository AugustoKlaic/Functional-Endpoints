package com.augusto.router;

import com.augusto.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Controller {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloHandler helloHandler) {
        return route()
                .GET("/hello", accept(APPLICATION_JSON), helloHandler::hello)
                .GET("/hello/{name}", accept(APPLICATION_JSON), helloHandler::helloWithName)
                .build();
    }
}
