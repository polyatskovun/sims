package mapper;

import dto.CaseDto;
import entity.CaseEntity;
import enums.Needs;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import model.Case;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T21:21:51+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class CaseMapperImpl implements CaseMapper {

    @Override
    public Case fromDtoToModel(CaseDto dto) {
        if ( dto == null ) {
            return null;
        }

        Case.CaseBuilder case1 = Case.builder();

        case1.name( dto.getName() );
        case1.time( dto.getTime() );
        Map<Needs, Integer> map = dto.getNeedsSuccessful();
        if ( map != null ) {
            case1.needsSuccessful( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Map<Needs, Integer> map1 = dto.getNeedsUnsuccessful();
        if ( map1 != null ) {
            case1.needsUnsuccessful( new LinkedHashMap<Needs, Integer>( map1 ) );
        }

        return case1.build();
    }

    @Override
    public CaseDto fromModelToDto(Case model) {
        if ( model == null ) {
            return null;
        }

        CaseDto.CaseDtoBuilder caseDto = CaseDto.builder();

        caseDto.name( model.getName() );
        caseDto.time( model.getTime() );
        Map<Needs, Integer> map = model.getNeedsSuccessful();
        if ( map != null ) {
            caseDto.needsSuccessful( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Map<Needs, Integer> map1 = model.getNeedsUnsuccessful();
        if ( map1 != null ) {
            caseDto.needsUnsuccessful( new LinkedHashMap<Needs, Integer>( map1 ) );
        }

        return caseDto.build();
    }

    @Override
    public Case fromEntityToModel(CaseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Case.CaseBuilder case1 = Case.builder();

        case1.name( entity.getName() );
        case1.time( entity.getTime() );
        Map<Needs, Integer> map = entity.getNeedsSuccessful();
        if ( map != null ) {
            case1.needsSuccessful( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Map<Needs, Integer> map1 = entity.getNeedsUnsuccessful();
        if ( map1 != null ) {
            case1.needsUnsuccessful( new LinkedHashMap<Needs, Integer>( map1 ) );
        }

        return case1.build();
    }

    @Override
    public CaseEntity fromModelToEntity(Case model) {
        if ( model == null ) {
            return null;
        }

        CaseEntity.CaseEntityBuilder caseEntity = CaseEntity.builder();

        caseEntity.name( model.getName() );
        caseEntity.time( model.getTime() );
        Map<Needs, Integer> map = model.getNeedsSuccessful();
        if ( map != null ) {
            caseEntity.needsSuccessful( new LinkedHashMap<Needs, Integer>( map ) );
        }
        Map<Needs, Integer> map1 = model.getNeedsUnsuccessful();
        if ( map1 != null ) {
            caseEntity.needsUnsuccessful( new LinkedHashMap<Needs, Integer>( map1 ) );
        }

        return caseEntity.build();
    }
}
