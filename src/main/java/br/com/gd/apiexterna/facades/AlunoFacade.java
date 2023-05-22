package br.com.gd.apiexterna.facades;

import br.com.gd.apiexterna.dtos.requests.AlunoResquestDTO;
import br.com.gd.apiexterna.dtos.responses.AlunoResponseDTO;

import java.util.List;

public interface AlunoFacade {

    AlunoResponseDTO cadastrarAluno(AlunoResquestDTO alunoResquestDTO);
    AlunoResponseDTO alterarAluno(String id, AlunoResquestDTO alunoResquestDTO);
    AlunoResponseDTO buscarPorId(String id);
    List<AlunoResponseDTO> listarAlunos();
    void removerAluno(String id);
}
