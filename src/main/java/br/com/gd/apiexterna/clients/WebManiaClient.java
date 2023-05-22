package br.com.gd.apiexterna.clients;

import br.com.gd.apiexterna.dtos.responses.EnderecoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WebmaniaBR", url="https://webmaniabr.com/api")
public interface WebManiaClient {

    @GetMapping("/1/cep/{cep}/")
    EnderecoResponseDTO obterEndereco(@PathVariable String cep,
                                      @RequestParam(required = false, value = "app_key") String appKey,
                                      @RequestParam(required = false, value = "app_secret") String appSecret);

}
