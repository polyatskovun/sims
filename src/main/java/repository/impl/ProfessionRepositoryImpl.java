package repository.impl;

import entity.ProfessionEntity;
import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.ProfessionRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfessionRepositoryImpl implements ProfessionRepository {

    private static ProfessionRepositoryImpl instance;
    Set<ProfessionEntity> set = new HashSet<>();

    private ProfessionRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsCook = new HashMap<>();
            needsCook.put(Needs.FOOD, 15);
            needsCook.put(Needs.WATER, 5);
            needsCook.put(Needs.ENTERTAINMENT, -35);
            needsCook.put(Needs.COMMUNICATION, 0);
            needsCook.put(Needs.HEALTHY, -5);
            needsCook.put(Needs.TOILET, 0);
            create(new ProfessionEntity("cook", 450, 600, needsCook));

            Map<Needs, Integer> needsPolice = new HashMap<>();
            needsPolice.put(Needs.FOOD, -10);
            needsPolice.put(Needs.WATER, 0);
            needsPolice.put(Needs.ENTERTAINMENT, -10);
            needsPolice.put(Needs.COMMUNICATION, 15);
            needsPolice.put(Needs.HEALTHY, -10);
            needsPolice.put(Needs.TOILET, -10);
            create(new ProfessionEntity("police", 600, 480, needsPolice));
        }
    }

    public static ProfessionRepositoryImpl getInstance(boolean isInitDefaultData) {
        if (instance == null) {
            instance = new ProfessionRepositoryImpl(isInitDefaultData);
        }
        return instance;
    }

    public static ProfessionRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProfessionRepositoryImpl();
        }
        return instance;
    }


    @Override
    public ProfessionEntity create(ProfessionEntity entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public ProfessionEntity update(ProfessionEntity entity) {
        Optional<ProfessionEntity> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            ProfessionEntity professionEntityForUpdate = optional.get();
            professionEntityForUpdate.setTime(entity.getTime());
            professionEntityForUpdate.setNeeds(entity.getNeeds());
            professionEntityForUpdate.setIncome(entity.getIncome());
            return professionEntityForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(ProfessionEntity entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<ProfessionEntity> findAll() {
        return set;
    }

    public ProfessionEntity findByName(String name) {
        for (ProfessionEntity x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }
}
