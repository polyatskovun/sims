package mapper;

import dto.ProfessionDto;
import entity.ProfessionEntity;
import model.Profession;
import org.mapstruct.Mapper;

@Mapper
public interface ProfessionMapper {


    Profession fromDtoToModel(ProfessionDto dto);

    ProfessionDto fromModelToDto(Profession model);

    Profession fromEntityToModel(ProfessionEntity entity);

    ProfessionEntity fromModelToEntity (Profession model);
}
