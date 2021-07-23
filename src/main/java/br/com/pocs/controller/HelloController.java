package br.com.pocs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController implements HelloControllerRoutes {

    @Get()
    public HttpResponse<String> helloWorld() {
        return HttpResponse.ok("Hello World, micronaut! -> " + HttpStatus.OK);
    }

    @Override
    public HttpResponse<String> helloNome(String nome) {
        return HttpResponse.ok("Hello World," + nome + "! -> " + HttpStatus.OK);
    }
}
