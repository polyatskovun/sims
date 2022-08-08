package service;

import entity.CaseEntity;
import lombok.Getter;
import lombok.Setter;
import mapper.CaseMapper;
import model.Case;
import org.mapstruct.factory.Mappers;
import repository.CaseRepository;
import repository.impl.CaseRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CaseService {

    private CaseMapper mapper = Mappers.getMapper(CaseMapper.class);
    private CaseRepository repository = CaseRepositoryImpl.getInstance();

    public Case create(Case model) {
        CaseEntity caseEntity = repository.create(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(caseEntity);
    }

    public Case update(Case model) {
        CaseEntity caseEntity = repository.update(mapper.fromModelToEntity(model));
        return mapper.fromEntityToModel(caseEntity);
    }

    public void delete(Case model) {
        repository.delete(mapper.fromModelToEntity(model));
    }

    public Set<Case> findAll() {
        return repository.findAll().stream().map(mapper::fromEntityToModel).collect(Collectors.toSet());
    }
}
