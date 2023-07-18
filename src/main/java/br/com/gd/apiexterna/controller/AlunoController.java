package br.com.gd.apiexterna.controller;

import br.com.gd.apiexterna.dtos.requests.AlunoResquestDTO;
import br.com.gd.apiexterna.dtos.responses.AlunoResponseDTO;
import br.com.gd.apiexterna.facades.AlunoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoFacade alunoFacade;

    @PostMapping
    public AlunoResponseDTO salvar(@RequestBody AlunoResquestDTO alunoResquestDTO){
        return alunoFacade.cadastrarAluno(alunoResquestDTO);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO alterar(@PathVariable String id, @RequestBody AlunoResquestDTO alunoResquestDTO){
        return alunoFacade.alterarAluno(id, alunoResquestDTO);
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscar(@PathVariable String id){
        return alunoFacade.buscarPorId(id);
    }

    @GetMapping
    public List<AlunoResponseDTO> listar(){
        return alunoFacade.listarAlunos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id){
        alunoFacade.removerAluno(id);
    }
}
