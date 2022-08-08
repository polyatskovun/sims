package repository.impl;

import entity.ProfessionEntity;
import enums.Needs;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfessionEntityRepositoryImplTest {

    @Test
    void create() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(false);
        Map<Needs, Integer> needsCook = new HashMap<>();
        needsCook.put(Needs.FOOD, 15);
        needsCook.put(Needs.WATER, 5);
        needsCook.put(Needs.ENTERTAINMENT, -35);
        needsCook.put(Needs.COMMUNICATION, 0);
        needsCook.put(Needs.HEALTHY, -5);
        needsCook.put(Needs.TOILET, 0);
        ProfessionEntity professionEntity = new ProfessionEntity("cook", 450, 600, needsCook);

        repository.create(professionEntity);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void update() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsCook = new HashMap<>();
        needsCook.put(Needs.FOOD, 15);
        needsCook.put(Needs.WATER, 5);
        needsCook.put(Needs.ENTERTAINMENT, -35);
        needsCook.put(Needs.COMMUNICATION, 0);
        needsCook.put(Needs.HEALTHY, -5);
        needsCook.put(Needs.TOILET, 0);
        ProfessionEntity professionEntity = new ProfessionEntity("cook", 550, 600, needsCook);

        ProfessionEntity professionEntityUpdate = repository.update(professionEntity);

        assertEquals(550, professionEntityUpdate.getIncome());
    }

    @Test
    void delete() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);
        ProfessionEntity professionEntity = new ProfessionEntity("cook", 450, 600, null);

        repository.delete(professionEntity);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void findAll() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);

        Set<ProfessionEntity> professionEntitySet = repository.findAll();

        assertEquals(2, professionEntitySet.size());
    }

    @Test
    void findByName() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);

        ProfessionEntity professionEntity = repository.findByName("police");

        assertEquals(600, professionEntity.getIncome());
    }
}