package br.com.pocs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;

public interface HelloControllerRoutes {

    @Get("/{nome}")
    HttpResponse<String> helloNome(String nome);

}
