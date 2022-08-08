package service;

import entity.CaseEntity;
import mapper.CaseMapper;
import model.Case;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.CaseRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaseEntityServiceTest {

    private Case model;
    private CaseEntity entity;
    private CaseService service;
    private CaseMapper mapper;
    private CaseRepository repository;

    @BeforeEach
    void before() {
        service = new CaseService();
        model = Case.builder()
                .name("Nastya")
                .time(1)
                .build();
        entity = CaseEntity.builder()
                .name("Nastya")
                .time(1)
                .build();
        mapper = Mockito.mock(CaseMapper.class);
        repository = Mockito.mock(CaseRepository.class);
        service.setRepository(repository);
        service.setMapper(mapper);

        Mockito.when(mapper.fromEntityToModel(entity)).thenReturn(model);
        Mockito.when(mapper.fromModelToEntity(model)).thenReturn(entity);
    }


    @Test
    void create() {
        Mockito.when(repository.create(entity)).thenReturn(entity);

        Case res = service.create(model);

        assertEquals(model.getName(), res.getName());
        Mockito.verify(repository).create(Mockito.any());
    }

    @Test
    void update() {
        Mockito.when(repository.update(entity)).thenReturn(entity);

        Case res = service.update(model);

        assertEquals(model.getName(), res.getName());
        Mockito.verify(repository).update(Mockito.any());
        Mockito.verify(mapper).fromModelToEntity(Mockito.any());
    }

    @Test
    void delete() {
        service.delete(model);

        Mockito.verify(repository).delete(Mockito.any());
        Mockito.verify(mapper).fromModelToEntity(Mockito.any());
    }

    @Test
    void findAll() {
        Set<CaseEntity> caseSet = new HashSet<>();
        caseSet.add(entity);
        Mockito.when(repository.findAll()).thenReturn(caseSet);
        Mockito.when(mapper.fromEntityToModel(Mockito.any())).thenReturn(model);

        service.findAll();

        Mockito.verify(repository).findAll();
        Mockito.verify(mapper).fromEntityToModel(Mockito.any());
    }

    @Test
    void findAllWhenEmpty() {
        Set<CaseEntity> caseSet = new HashSet<>();
        Mockito.when(repository.findAll()).thenReturn(caseSet);

        service.findAll();

        Mockito.verify(repository).findAll();
    }
}