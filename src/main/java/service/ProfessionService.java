package service;

import dto.ModelDto;
import dto.ProfessionDto;
import mapper.ProfessionMapper;
import model.Model;
import model.Profession;
import org.mapstruct.factory.Mappers;
import repository.ProfessionRepository;
import repository.impl.ProfessionRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfessionService {

    private final ProfessionMapper mapper = Mappers.getMapper(ProfessionMapper.class);
    private final ProfessionRepository repository = ProfessionRepositoryImpl.getInstance();

    public ProfessionDto create(ProfessionDto dto) {
        Profession model = repository.create(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public ProfessionDto update (ProfessionDto dto){
        Profession model = repository.update(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public  void delete (ProfessionDto dto){
        repository.delete(mapper.toModel(dto));
    }

    public Set<ProfessionDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }
}
