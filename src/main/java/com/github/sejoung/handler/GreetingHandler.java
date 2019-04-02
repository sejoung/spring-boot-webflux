package com.github.sejoung.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {


    public Mono<ServerResponse> hello(ServerRequest request) {

        request.attributes().forEach((k,v)-> {
            System.out.println(k+" "+v);
        });

        System.out.println(request.headers().toString());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring!"));
    }
}
