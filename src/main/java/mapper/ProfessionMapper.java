package mapper;

import dto.ProfessionDto;
import model.Profession;
import org.mapstruct.Mapper;

@Mapper
public interface ProfessionMapper {

    Profession toModel(ProfessionDto dto);

    ProfessionDto toDto(Profession model);
}
