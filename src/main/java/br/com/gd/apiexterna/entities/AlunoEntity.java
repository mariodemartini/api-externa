package br.com.gd.apiexterna.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoEntity {

    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
