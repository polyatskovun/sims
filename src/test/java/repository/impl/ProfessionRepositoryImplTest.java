package repository.impl;

import enums.Needs;
import model.Habit;
import model.Profession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionRepositoryImplTest {

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
        Profession profession = new Profession("cook", 450, 600, needsCook);

        repository.create(profession);

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
        Profession profession = new Profession("cook", 550, 600, needsCook);

        Profession professionUpdate = repository.update(profession);

        assertEquals(550, professionUpdate.getIncome());
    }

    @Test
    void delete() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);
        Profession profession = new Profession("cook", 450, 600, null);

        repository.delete(profession);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void findAll() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);

        Set<Profession> professionSet = repository.findAll();

        assertEquals(2, professionSet.size());
    }

    @Test
    void findByName() {
        ProfessionRepositoryImpl repository = ProfessionRepositoryImpl.getInstance(true);

        Profession profession = repository.findByName("police");

        assertEquals(600, profession.getIncome());
    }
}