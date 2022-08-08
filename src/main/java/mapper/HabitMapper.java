package mapper;

import dto.HabitDto;
import entity.HabitEntity;
import model.Habit;
import org.mapstruct.Mapper;

@Mapper
public interface HabitMapper {

    Habit fromDtoToModel(HabitDto dto);

    HabitDto fromModelToDto(Habit model);

    Habit fromEntityToModel (HabitEntity entity);

    HabitEntity fromModelToEntity (Habit model);

}
