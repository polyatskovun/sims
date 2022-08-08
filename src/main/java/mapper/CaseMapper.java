package mapper;

import dto.CaseDto;
import model.Case;
import org.mapstruct.Mapper;

@Mapper
public interface CaseMapper {

    Case toModel(CaseDto dto);
    CaseDto toDto(Case dto);

}
