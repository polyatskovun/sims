package repository.impl;

import entity.HabitEntity;
import entity.ModelEntity;
import enums.Age;
import enums.Needs;
import enums.Sex;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelEntityRepositoryImplTest {


    @Test
    void create() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(false);
        Map<Needs, Integer> needsAlex = new HashMap<>();
        needsAlex.put(Needs.FOOD, 100);
        needsAlex.put(Needs.WATER, 100);
        needsAlex.put(Needs.TOILET, 100);
        needsAlex.put(Needs.COMMUNICATION, 100);
        needsAlex.put(Needs.ENTERTAINMENT, 100);
        needsAlex.put(Needs.HEALTHY, 100);
        Set<HabitEntity> set1 = new HashSet<>();
        ModelEntity modelEntity = new ModelEntity(null, "Alex", Age.ADULT, Sex.MAN, 200, needsAlex, set1, null, null);

        repository.create(modelEntity);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void update() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsAlex = new HashMap<>();
        needsAlex.put(Needs.FOOD, 100);
        needsAlex.put(Needs.WATER, 100);
        needsAlex.put(Needs.TOILET, 100);
        needsAlex.put(Needs.COMMUNICATION, 100);
        needsAlex.put(Needs.ENTERTAINMENT, 100);
        needsAlex.put(Needs.HEALTHY, 100);
        Set<HabitEntity> set1 = new HashSet<>();
        ModelEntity modelEntity = new ModelEntity(null, "Alex", Age.ADULT, Sex.WOMAN, 200, needsAlex, set1, null, null);

        ModelEntity updateModelEntity = repository.update(modelEntity);

        assertEquals(Sex.WOMAN, updateModelEntity.getSex());
    }

    @Test
    void delete() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);
        ModelEntity modelEntity = repository.getSet().iterator().next();

        repository.delete(modelEntity);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void findAll() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);

        Set<ModelEntity> modelEntitySet = repository.findAll();

        assertEquals(2, modelEntitySet.size());

    }

    @Test
    void findByName() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);

        ModelEntity modelEntity = repository.findByName("Alex");

        assertEquals(200, modelEntity.getMoney());
    }
}