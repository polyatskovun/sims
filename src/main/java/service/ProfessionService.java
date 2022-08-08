package service;

import entity.ProfessionEntity;
import lombok.Getter;
import lombok.Setter;
import mapper.ProfessionMapper;
import model.Profession;
import org.mapstruct.factory.Mappers;
import repository.ProfessionRepository;
import repository.impl.ProfessionRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProfessionService {

    private final ProfessionMapper mapper = Mappers.getMapper(ProfessionMapper.class);
    private final ProfessionRepository repository = ProfessionRepositoryImpl.getInstance();

    public Profession create(Profession model) {
        ProfessionEntity entity = repository.create(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public Profession update(Profession model) {
        ProfessionEntity entity = repository.update(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public void delete(Profession model) {
        repository.delete(mapper.fromModelToEntity(model));
    }

    public Set<Profession> findAll() {
        return repository.findAll().stream().map(mapper::fromEntityToModel).collect(Collectors.toSet());
    }
}
