package br.com.gd.apiexterna.services;

import br.com.gd.apiexterna.entities.AlunoEntity;

import java.util.List;

public interface AlunoService {

    AlunoEntity cadastrarAluno(AlunoEntity alunoEntity);
    AlunoEntity alterarAluno(String id, AlunoEntity alunoEntity);
    AlunoEntity buscarAlunoPorId(String id);
    List<AlunoEntity> listarAlunos();
    void removerAluno(String id);
}
