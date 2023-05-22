package br.com.gd.apiexterna.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoResponseDTO {

    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String endereco;

}
