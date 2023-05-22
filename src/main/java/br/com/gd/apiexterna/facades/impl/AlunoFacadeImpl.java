package br.com.gd.apiexterna.facades.impl;

import br.com.gd.apiexterna.dtos.requests.AlunoResquestDTO;
import br.com.gd.apiexterna.dtos.responses.AlunoResponseDTO;
import br.com.gd.apiexterna.facades.AlunoFacade;
import br.com.gd.apiexterna.mappers.AlunoMapper;
import br.com.gd.apiexterna.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoFacadeImpl implements AlunoFacade {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoMapper alunoMapper;

    @Override
    public AlunoResponseDTO cadastrarAluno(AlunoResquestDTO alunoResquestDTO) {
        return alunoMapper.paraDTO(alunoService.cadastrarAluno(alunoMapper.paraEntidade(alunoResquestDTO)));
    }

    @Override
    public AlunoResponseDTO alterarAluno(String id, AlunoResquestDTO alunoResquestDTO) {
        return alunoMapper.paraDTO(alunoService.alterarAluno(id, alunoMapper.paraEntidade(alunoResquestDTO)));
    }

    @Override
    public AlunoResponseDTO buscarPorId(String id) {
        return alunoMapper.paraDTO(alunoService.buscarAlunoPorId(id));
    }

    @Override
    public List<AlunoResponseDTO> listarAlunos() {
        return alunoMapper.paraListaDTO(alunoService.listarAlunos());
    }

    @Override
    public void removerAluno(String id) {
        alunoService.removerAluno(id);
    }
}
