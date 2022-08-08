package service;

import dto.HabitDto;
import mapper.HabitMapper;
import model.Habit;
import org.mapstruct.factory.Mappers;
import repository.HabitRepository;
import repository.impl.HabitRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

public class HabitService {
    private final HabitMapper mapper = Mappers.getMapper(HabitMapper.class);
    private final HabitRepository repository = HabitRepositoryImpl.getInstance();

    public HabitDto create(HabitDto dto) {
        Habit model = repository.create(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public HabitDto update (HabitDto dto){
        Habit model = repository.update(mapper.toModel(dto));
        return mapper.toDto(model);
    }

    public  void delete (HabitDto dto){
        repository.delete(mapper.toModel(dto));
    }

    public Set<HabitDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }
}
