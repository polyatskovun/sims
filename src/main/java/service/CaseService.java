package service;

import dto.CaseDto;
import mapper.CaseMapper;
import model.Case;
import org.mapstruct.factory.Mappers;
import repository.CaseRepository;
import repository.impl.CaseRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

public class CaseService {

    private final CaseMapper mapper = Mappers.getMapper(CaseMapper.class);
    private final CaseRepository repository = CaseRepositoryImpl.getInstance();

    public CaseDto create(CaseDto dto) {
        Case modelCase = repository.create(mapper.toModel(dto));
        return mapper.toDto(modelCase);
    }

    public CaseDto update (CaseDto dto){
        Case model = repository.update(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public  void delete (CaseDto dto){
        repository.delete(mapper.toModel(dto));
    }

    public Set<CaseDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }
}
