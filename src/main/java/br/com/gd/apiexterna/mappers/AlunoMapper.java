package br.com.gd.apiexterna.mappers;


import br.com.gd.apiexterna.dtos.requests.AlunoResquestDTO;
import br.com.gd.apiexterna.dtos.responses.AlunoResponseDTO;
import br.com.gd.apiexterna.entities.AlunoEntity;
import br.com.gd.apiexterna.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class AlunoMapper {

    @Autowired
    private ModelMapper mapper;

    public AlunoResponseDTO paraDTO(AlunoEntity alunoEntity){
        log.info("convertendo entidade para dto");
        return mapper.map(alunoEntity, AlunoResponseDTO.class);
    }

    public AlunoEntity paraEntidade(AlunoResquestDTO alunoResquestDTO){
        log.info("convertendo dto para entidade");
        return mapper.map(alunoResquestDTO, AlunoEntity.class);
    }

    public List<AlunoResponseDTO> paraListaDTO(List<AlunoEntity> lista){
        log.info("convertendo lista de entidade para lista dto");
        List<AlunoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return resultado.stream().map(this::paraDTO).collect(Collectors.toList());
    }

}
