package br.com.pocs.services;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.netty.DefaultHttpClient;

import javax.inject.Singleton;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Singleton
public class CepService {

    private static final String URI_CEP = "https://viacep.com.br/ws/";
    private static final String URI_CEP_BOTTON = "/json/";

    public String recuperaEndereco(final String numCep){
        HttpRequest<?> req = HttpRequest.GET(URI_CEP + numCep + URI_CEP_BOTTON)
                .header(USER_AGENT, "Micronaut HTTP Client")
                .header(ACCEPT, "application/json");

        RxHttpClient rxHttpClient = new DefaultHttpClient();
        String resultado = rxHttpClient.toBlocking().retrieve(req);
        rxHttpClient.close();

        return resultado;
    }

}
