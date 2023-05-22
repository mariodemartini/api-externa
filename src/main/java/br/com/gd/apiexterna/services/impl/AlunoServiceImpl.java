package br.com.gd.apiexterna.services.impl;

import br.com.gd.apiexterna.entities.AlunoEntity;
import br.com.gd.apiexterna.repositories.AlunoRepository;
import br.com.gd.apiexterna.services.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public AlunoEntity cadastrarAluno(AlunoEntity alunoEntity) {
        log.info("cadastrando novo aluno: {}", alunoEntity);
        return alunoRepository.save(alunoEntity);
    }

    @Override
    public AlunoEntity alterarAluno(String id, AlunoEntity alunoEntity) {
        log.info("alternando aluno de id {}", id);
        buscarAlunoPorId(id);
        alunoEntity.setId(id);
        return alunoRepository.save(alunoEntity);
    }

    @Override
    public AlunoEntity buscarAlunoPorId(String id) {
        log.info("pesquisando aluno de id {}", id);
        return alunoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<AlunoEntity> listarAlunos() {
        log.info("listando todos os alunos");
        return alunoRepository.findAll();
    }

    @Override
    public void removerAluno(String id) {
        log.info("removendo aluno de id {}", id);
        alunoRepository.deleteById(id);
    }
}
