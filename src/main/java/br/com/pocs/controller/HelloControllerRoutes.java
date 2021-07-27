package br.com.pocs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;

public interface HelloControllerRoutes {

    @Get("/{nome}")
    HttpResponse<String> helloNome(String nome);

    @Get(uri = "/cep/{numero}", produces = MediaType.APPLICATION_JSON_STREAM)
    HttpResponse<String> requestCep(String numero);
}
