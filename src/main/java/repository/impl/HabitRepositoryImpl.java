package repository.impl;

import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Habit;
import repository.HabitRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HabitRepositoryImpl implements HabitRepository {

    private static HabitRepositoryImpl instance;
    Set<Habit> set = new HashSet<>();

    private HabitRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsInsatiable = new HashMap<>();
            needsInsatiable.put(Needs.FOOD, -10);
            create(new Habit("insatiable", needsInsatiable));

            Map<Needs, Integer> needsCommunicative = new HashMap<>();
            needsCommunicative.put(Needs.COMMUNICATION, 5);
            create(new Habit("communicative", needsCommunicative));
        }
    }

    public static HabitRepositoryImpl getInstance(boolean isInitDefaultData) {
        if (instance == null) {
            instance = new HabitRepositoryImpl(isInitDefaultData);
        }
        return instance;
    }

    public static HabitRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new HabitRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Habit create(Habit entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public Habit update(Habit entity) {
        Optional<Habit> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            Habit habitForUpdate = optional.get();
            habitForUpdate.setNeeds(entity.getNeeds());
            return habitForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(Habit entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<Habit> findAll() {
        return set;
    }

    public Habit findByName(String name) {
        for (Habit x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }


}
