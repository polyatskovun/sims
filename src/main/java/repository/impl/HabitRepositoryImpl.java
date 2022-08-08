package repository.impl;

import entity.HabitEntity;
import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.HabitRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HabitRepositoryImpl implements HabitRepository {

    private static HabitRepositoryImpl instance;
    Set<HabitEntity> set = new HashSet<>();

    private HabitRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsInsatiable = new HashMap<>();
            needsInsatiable.put(Needs.FOOD, -10);
            create(new HabitEntity("insatiable", needsInsatiable));

            Map<Needs, Integer> needsCommunicative = new HashMap<>();
            needsCommunicative.put(Needs.COMMUNICATION, 5);
            create(new HabitEntity("communicative", needsCommunicative));
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
    public HabitEntity create(HabitEntity entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public HabitEntity update(HabitEntity entity) {
        Optional<HabitEntity> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            HabitEntity habitEntityForUpdate = optional.get();
            habitEntityForUpdate.setNeeds(entity.getNeeds());
            return habitEntityForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(HabitEntity entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<HabitEntity> findAll() {
        return set;
    }

    public HabitEntity findByName(String name) {
        for (HabitEntity x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }


}
