package repository.impl;

import enums.Needs;
import model.Habit;
import org.junit.jupiter.api.Test;
import repository.HabitRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class HabitRepositoryImplTest {

    @Test
    void create() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(false);
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 5);
        Habit habit = new Habit("communicative", needsCommunicative);

        repository.create(habit);

        assertEquals(1, repository.getSet().size());
    }

    @Test
    void update() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 10);
        Habit habit = new Habit("communicative", needsCommunicative);

        repository.update(habit);

        assertEquals(10, Objects.requireNonNull(findByName("communicative", repository.getSet())).getNeeds().get(Needs.COMMUNICATION));
    }

    @Test
    void delete() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);
        int startSize = repository.getSet().size();
        Map<Needs, Integer> needsCommunicative = new HashMap<>();
        needsCommunicative.put(Needs.COMMUNICATION, 5);
        Habit habit = new Habit("communicative", needsCommunicative);

        repository.delete(habit);

        assertEquals(startSize - 1, repository.getSet().size());
    }

    @Test
    void findAll() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);

        Set<Habit> habitSet = repository.findAll();

        assertEquals(2, repository.getSet().size());
    }

    @Test
    void findByName() {
        HabitRepositoryImpl repository = HabitRepositoryImpl.getInstance(true);

        Habit habit = repository.findByName("insatiable");

        assertEquals(-10, habit.getNeeds().get(Needs.FOOD));
    }

    private Habit findByName(String name, Set<Habit> set) {
        for (Habit habit : set) {
            if (habit.getName().equals(name)) {
                return habit;
            }
        }
        return null;
    }
}