package mapper;

import dto.ModelDto;
import dto.ModelInsertDto;
import entity.ModelEntity;
import model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ModelMapper {

    Model fromDtoToModel(ModelDto dto);

    @Mapping(target = "id", ignore = true)
    Model fromDtoToModel(ModelInsertDto dto);

    ModelDto fromModelToDto(Model model);

    ModelEntity fromModelToEntity(Model model);

    Model fromEntityToModel(ModelEntity entity);


}
