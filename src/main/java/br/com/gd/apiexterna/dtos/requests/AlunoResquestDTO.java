package br.com.gd.apiexterna.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoResquestDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String cep;

}
