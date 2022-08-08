package mapper;

import dto.HabitDto;
import model.Habit;
import org.mapstruct.Mapper;

@Mapper
public interface HabitMapper {

    Habit toModel(HabitDto dto);

    HabitDto toDto(Habit model);

}
