package service;

import entity.ModelEntity;
import lombok.Getter;
import lombok.Setter;
import mapper.ModelMapper;
import model.Model;
import org.mapstruct.factory.Mappers;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ModelService {

    private  ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private  ModelRepository repository = ModelRepositoryImpl.getInstance();

    public Model create(Model model) {
        ModelEntity entity = repository.create(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public Model update(Model model) {
        ModelEntity entity = repository.update(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public void delete(Model model) {
        repository.delete(mapper.fromModelToEntity(model));
    }

    public Set<Model> findAll() {
        return repository.findAll().stream().map(mapper::fromEntityToModel).collect(Collectors.toSet());
    }

}
