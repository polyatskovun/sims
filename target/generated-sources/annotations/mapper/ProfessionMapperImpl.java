package mapper;

import dto.ProfessionDto;
import entity.ProfessionEntity;
import enums.Needs;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import model.Profession;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T21:21:51+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ProfessionMapperImpl implements ProfessionMapper {

    @Override
    public Profession fromDtoToModel(ProfessionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profession.ProfessionBuilder profession = Profession.builder();

        profession.name( dto.getName() );
        profession.income( dto.getIncome() );
        profession.time( dto.getTime() );
        Map<Needs, Integer> map = dto.getNeeds();
        if ( map != null ) {
            profession.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return profession.build();
    }

    @Override
    public ProfessionDto fromModelToDto(Profession model) {
        if ( model == null ) {
            return null;
        }

        ProfessionDto.ProfessionDtoBuilder professionDto = ProfessionDto.builder();

        professionDto.name( model.getName() );
        professionDto.income( model.getIncome() );
        professionDto.time( model.getTime() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            professionDto.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return professionDto.build();
    }

    @Override
    public Profession fromEntityToModel(ProfessionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Profession.ProfessionBuilder profession = Profession.builder();

        profession.name( entity.getName() );
        profession.income( entity.getIncome() );
        profession.time( entity.getTime() );
        Map<Needs, Integer> map = entity.getNeeds();
        if ( map != null ) {
            profession.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return profession.build();
    }

    @Override
    public ProfessionEntity fromModelToEntity(Profession model) {
        if ( model == null ) {
            return null;
        }

        ProfessionEntity.ProfessionEntityBuilder professionEntity = ProfessionEntity.builder();

        professionEntity.name( model.getName() );
        professionEntity.income( model.getIncome() );
        professionEntity.time( model.getTime() );
        Map<Needs, Integer> map = model.getNeeds();
        if ( map != null ) {
            professionEntity.needs( new LinkedHashMap<Needs, Integer>( map ) );
        }

        return professionEntity.build();
    }
}
