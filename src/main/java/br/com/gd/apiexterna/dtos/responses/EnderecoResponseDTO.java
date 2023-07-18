package br.com.gd.apiexterna.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoResponseDTO {

    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
}
