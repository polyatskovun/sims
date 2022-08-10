package service;

import entity.HabitEntity;
import lombok.Getter;
import lombok.Setter;
import mapper.HabitMapper;
import model.Habit;
import org.mapstruct.factory.Mappers;
import repository.HabitRepository;
import repository.impl.HabitRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class HabitService {

    private  HabitMapper mapper = Mappers.getMapper(HabitMapper.class);
    private  HabitRepository repository = HabitRepositoryImpl.getInstance();
    public Habit create(Habit model) {
        HabitEntity entity = repository.create(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public Habit update(Habit model) {
        HabitEntity entity = repository.update(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(entity);
    }

    public void delete(Habit model) {
        repository.delete(mapper.fromModelToEntity(model));
    }

    public Set<Habit> findAll() {
        return repository.findAll().stream().map(mapper::fromEntityToModel).collect(Collectors.toSet());
    }
}
