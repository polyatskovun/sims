package mapper;

import dto.HabitDto;
import entity.HabitEntity;
import enums.Needs;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import model.Habit;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T21:21:51+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class HabitMapperImpl implements HabitMapper {

    @Override
    public Habit fromDtoToModel(HabitDto dto) {
        if ( dto == null ) {
            return null;
        }

        Habit.HabitBuilder habit = Habit.builder();

        habit.name( dto.getName() );
        Map<Needs, Integer> map = dto.getNeeds();
        if ( map != null ) {
            habit.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return habit.build();
    }

    @Override
    public HabitDto fromModelToDto(Habit model) {
        if ( model == null ) {
            return null;
        }

        HabitDto.HabitDtoBuilder habitDto = HabitDto.builder();

        habitDto.name( model.getName() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            habitDto.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return habitDto.build();
    }

    @Override
    public Habit fromEntityToModel(HabitEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Habit.HabitBuilder habit = Habit.builder();

        habit.name( entity.getName() );
        Map<Needs, Integer> map = entity.getNeeds();
        if ( map != null ) {
            habit.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return habit.build();
    }

    @Override
    public HabitEntity fromModelToEntity(Habit model) {
        if ( model == null ) {
            return null;
        }

        HabitEntity.HabitEntityBuilder habitEntity = HabitEntity.builder();

        habitEntity.name( model.getName() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            habitEntity.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return habitEntity.build();
    }
}
