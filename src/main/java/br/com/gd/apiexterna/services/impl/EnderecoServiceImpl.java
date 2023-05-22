package br.com.gd.apiexterna.services.impl;

import br.com.gd.apiexterna.clients.WebManiaClient;
import br.com.gd.apiexterna.dtos.responses.EnderecoResponseDTO;
import br.com.gd.apiexterna.services.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private WebManiaClient webManiaClient;

    @Override
    public EnderecoResponseDTO obterEndereco(String cep, String key, String secret){
        log.info("pegando endereco de api externa");
        return webManiaClient.obterEndereco(cep, key, secret);
    }
}
