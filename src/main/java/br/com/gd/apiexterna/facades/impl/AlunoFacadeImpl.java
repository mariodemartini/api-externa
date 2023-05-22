package br.com.gd.apiexterna.facades.impl;

import br.com.gd.apiexterna.dtos.requests.AlunoResquestDTO;
import br.com.gd.apiexterna.dtos.responses.AlunoResponseDTO;
import br.com.gd.apiexterna.dtos.responses.EnderecoResponseDTO;
import br.com.gd.apiexterna.entities.AlunoEntity;
import br.com.gd.apiexterna.facades.AlunoFacade;
import br.com.gd.apiexterna.mappers.AlunoMapper;
import br.com.gd.apiexterna.services.AlunoService;
import br.com.gd.apiexterna.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoFacadeImpl implements AlunoFacade {

    private final String APP_KEY = "5NsC4AHjtKbAoHz5ZHSeVqenQObjje15";

    private final String APP_SECRET = "FbltlLFrZeFbvVYlvY1FNhqrOBXNVYpNVSsEXLg810ZZyb4R";

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private AlunoMapper alunoMapper;

    @Override
    public AlunoResponseDTO cadastrarAluno(AlunoResquestDTO alunoResquestDTO) {
        EnderecoResponseDTO endereco = enderecoService.obterEndereco(alunoResquestDTO.getCep(), APP_KEY, APP_SECRET);
        AlunoEntity aluno = alunoMapper.paraEntidade(alunoResquestDTO);
        aluno.setEndereco(endereco.getEndereco());
        aluno.setBairro(endereco.getBairro());
        aluno.setCidade(endereco.getCidade());
        aluno.setUf(endereco.getUf());
        aluno.setCep(endereco.getCep());

        return alunoMapper.paraDTO(alunoService.cadastrarAluno(aluno));
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
