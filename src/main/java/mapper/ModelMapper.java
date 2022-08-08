package mapper;

import dto.ModelDto;
import dto.ModelInsertDto;
import model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ModelMapper {

    Model toModel(ModelDto dto);

    @Mapping(target = "id", ignore = true)
    Model toModel(ModelInsertDto dto);

    ModelDto toDto(Model model);

}
