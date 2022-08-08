package repository.impl;

import entity.HabitEntity;
import enums.Needs;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HabitEntityRepositoryImplTest {

    @Test
    void create() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(false);
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 5);
        HabitEntity habitEntity = new HabitEntity("communicative", needsCommunicative);

        repository.create(habitEntity);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void update() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 10);
        HabitEntity habitEntity = new HabitEntity("communicative", needsCommunicative);

        repository.update(habitEntity);

        assertEquals(10, Objects.requireNonNull(findByName("communicative", repository.getSet())).getNeeds().get(Needs.COMMUNICATION));
    }

    @Test
    void delete() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);
        int startSize = repository.getSet().size();
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 5);
        HabitEntity habitEntity = new HabitEntity("communicative", needsCommunicative);

        repository.delete(habitEntity);

        assertEquals(startSize - 1, repository.getSet().size());
    }

    @Test
    void findAll() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);

        Set<HabitEntity> habitEntitySet = repository.findAll();

        assertEquals(2, repository.getSet().size());
    }

    @Test
    void findByName() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);

        HabitEntity habitEntity = repository.findByName("insatiable");

        assertEquals(-10, habitEntity.getNeeds().get(Needs.FOOD));
    }

    private HabitEntity findByName(String name, Set<HabitEntity> set) {
        for (HabitEntity habitEntity : set) {
            if (habitEntity.getName().equals(name)) {
                return habitEntity;
            }
        }
        return null;
    }
}