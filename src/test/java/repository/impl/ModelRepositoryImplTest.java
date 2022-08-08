package repository.impl;

import enums.Age;
import enums.Needs;
import enums.Sex;
import model.Habit;
import model.Model;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelRepositoryImplTest {



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
        Set<Habit> set1 = new HashSet<>();
        Model model = new Model("Alex", Age.ADULT, Sex.MAN, 200, needsAlex, set1, null, null);

        repository.create(model);

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
        Set<Habit> set1 = new HashSet<>();
        Model model = new Model("Alex", Age.ADULT, Sex.WOMAN, 200, needsAlex, set1, null, null);

        Model updateModel = repository.update(model);

        assertEquals(Sex.WOMAN, updateModel.getSex());
    }

    @Test
    void delete() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);
        Model model = repository.getSet().iterator().next();

        repository.delete(model);

        assertEquals(1 , repository.getSet().size());
    }

    @Test
    void findAll() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);

        Set <Model> modelSet = repository.findAll();

        assertEquals(2, modelSet.size());

    }

    @Test
    void findByName() {
        ModelRepositoryImpl repository = ModelRepositoryImpl.getInstance(true);

        Model model = repository.findByName("Alex");

        assertEquals(200, model.getMoney());
    }
}