package mapper;

import dto.CaseDto;
import entity.CaseEntity;
import model.Case;
import org.mapstruct.Mapper;

@Mapper
public interface CaseMapper {

    Case fromDtoToModel(CaseDto dto);

    CaseDto fromModelToDto(Case model);

    Case fromEntityToModel(CaseEntity entity);

    CaseEntity fromModelToEntity(Case model);

}
