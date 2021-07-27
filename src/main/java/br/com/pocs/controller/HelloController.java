package br.com.pocs.controller;

import br.com.pocs.services.CepService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller("${hello.controller.path}")
public class HelloController implements HelloControllerRoutes {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    //    @Inject
    //    private CepService cepService;

    private final CepService cepService;
    //Recomendado
    public HelloController(final CepService cepService) {
        this.cepService = cepService;
    }

    @Get()
    public HttpResponse<String> helloWorld() {
        return HttpResponse.ok("Hello World, micronaut! -> " + HttpStatus.OK);
    }

    @Override
    public HttpResponse<String> helloNome(String nome) {
        return HttpResponse.ok("Hello World," + nome + "! -> " + HttpStatus.OK);
    }

    @Override
    public HttpResponse<String> requestCep(String numero) {
        String retornoCep = cepService.recuperaEndereco(numero);
        LOG.info("Retorno da api: {}", retornoCep);
        return HttpResponse.ok("Endereco: " + retornoCep);
    }
}
