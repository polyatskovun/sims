package service;

import dto.HabitDto;
import dto.ModelDto;
import mapper.ModelMapper;
import model.Habit;
import model.Model;
import org.mapstruct.factory.Mappers;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

public class ModelService {

    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final ModelRepository repository = ModelRepositoryImpl.getInstance();

    public ModelDto create(ModelDto dto) {
        Model model = repository.create(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public ModelDto update (ModelDto dto){
        Model model = repository.update(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public  void delete (ModelDto dto){
        repository.delete(mapper.toModel(dto));
    }

    public Set<ModelDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }

}
