package br.com.gd.apiexterna.controller;

import br.com.gd.apiexterna.entities.AlunoEntity;
import br.com.gd.apiexterna.repositories.AlunoRepository;
import br.com.gd.apiexterna.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoEntity salvar(@RequestBody AlunoEntity alunoEntity){
        return alunoService.cadastrarAluno(alunoEntity);
    }

    @PutMapping("/{id}")
    public AlunoEntity alterar(@PathVariable String id, @RequestBody AlunoEntity alunoEntity){
        return alunoService.alterarAluno(id, alunoEntity);
    }

    @GetMapping("/{id}")
    public AlunoEntity buscar(@PathVariable String id){
        return alunoService.buscarAlunoPorId(id);
    }

    @GetMapping
    public List<AlunoEntity> listar(){
        return alunoService.listarAlunos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id){
        alunoService.removerAluno(id);
    }
}
