package mapper;

import dto.ModelDto;
import dto.ModelInsertDto;
import entity.HabitEntity;
import entity.ModelEntity;
import enums.Needs;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import model.Model;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T21:21:51+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public Model fromDtoToModel(ModelDto dto) {
        if ( dto == null ) {
            return null;
        }

        Model.ModelBuilder model = Model.builder();

        model.id( dto.getId() );
        model.name( dto.getName() );
        model.age( dto.getAge() );
        model.sex( dto.getSex() );
        model.money( dto.getMoney() );
        Map<Needs, Integer> map = dto.getNeeds();
        if ( map != null ) {
            model.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Set<HabitEntity> set = dto.getHabitEntities();
        if ( set != null ) {
            model.habitEntities( new LinkedHashSet<HabitEntity>( set ) );
        }
        model.professionEntity( dto.getProfessionEntity() );
        model.roundCaseEntity( dto.getRoundCaseEntity() );

        return model.build();
    }

    @Override
    public Model fromDtoToModel(ModelInsertDto dto) {
        if ( dto == null ) {
            return null;
        }

        Model.ModelBuilder model = Model.builder();

        model.name( dto.getName() );
        model.age( dto.getAge() );
        model.sex( dto.getSex() );
        model.money( dto.getMoney() );
        Map<Needs, Integer> map = dto.getNeeds();
        if ( map != null ) {
            model.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Set<HabitEntity> set = dto.getHabitEntities();
        if ( set != null ) {
            model.habitEntities( new LinkedHashSet<HabitEntity>( set ) );
        }
        model.professionEntity( dto.getProfessionEntity() );
        model.roundCaseEntity( dto.getRoundCaseEntity() );

        return model.build();
    }

    @Override
    public ModelDto fromModelToDto(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelDto.ModelDtoBuilder modelDto = ModelDto.builder();

        modelDto.id( model.getId() );
        modelDto.name( model.getName() );
        modelDto.age( model.getAge() );
        modelDto.sex( model.getSex() );
        modelDto.money( model.getMoney() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            modelDto.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Set<HabitEntity> set = model.getHabitEntities();
        if ( set != null ) {
            modelDto.habitEntities( new LinkedHashSet<HabitEntity>( set ) );
        }
        modelDto.professionEntity( model.getProfessionEntity() );
        modelDto.roundCaseEntity( model.getRoundCaseEntity() );

        return modelDto.build();
    }

    @Override
    public ModelEntity fromModelToEntity(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelEntity.ModelEntityBuilder modelEntity = ModelEntity.builder();

        modelEntity.id( model.getId() );
        modelEntity.name( model.getName() );
        modelEntity.age( model.getAge() );
        modelEntity.sex( model.getSex() );
        modelEntity.money( model.getMoney() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            modelEntity.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Set<HabitEntity> set = model.getHabitEntities();
        if ( set != null ) {
            modelEntity.habitEntities( new LinkedHashSet<HabitEntity>( set ) );
        }
        modelEntity.professionEntity( model.getProfessionEntity() );
        modelEntity.roundCaseEntity( model.getRoundCaseEntity() );

        return modelEntity.build();
    }

    @Override
    public Model fromEntityToModel(ModelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Model.ModelBuilder model = Model.builder();

        model.id( entity.getId() );
        model.name( entity.getName() );
        model.age( entity.getAge() );
        model.sex( entity.getSex() );
        model.money( entity.getMoney() );
        Map<Needs, Integer> map = entity.getNeeds();
        if ( map != null ) {
            model.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Set<HabitEntity> set = entity.getHabitEntities();
        if ( set != null ) {
            model.habitEntities( new LinkedHashSet<HabitEntity>( set ) );
        }
        model.professionEntity( entity.getProfessionEntity() );
        model.roundCaseEntity( entity.getRoundCaseEntity() );

        return model.build();
    }
}
