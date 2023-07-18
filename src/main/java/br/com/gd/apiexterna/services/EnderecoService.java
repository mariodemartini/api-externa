package br.com.gd.apiexterna.services;

import br.com.gd.apiexterna.dtos.responses.EnderecoResponseDTO;

public interface EnderecoService {

    EnderecoResponseDTO obterEndereco(String cep, String key, String secret);
}
