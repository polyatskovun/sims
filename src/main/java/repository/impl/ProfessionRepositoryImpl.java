package repository.impl;

import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Profession;
import repository.ProfessionRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfessionRepositoryImpl implements ProfessionRepository {

    private static ProfessionRepositoryImpl instance;
    Set<Profession> set = new HashSet<>();

    private ProfessionRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsCook = new HashMap<>();
            needsCook.put(Needs.FOOD, 15);
            needsCook.put(Needs.WATER, 5);
            needsCook.put(Needs.ENTERTAINMENT, -35);
            needsCook.put(Needs.COMMUNICATION, 0);
            needsCook.put(Needs.HEALTHY, -5);
            needsCook.put(Needs.TOILET, 0);
            create(new Profession("cook", 450, 600, needsCook));

            Map<Needs, Integer> needsPolice = new HashMap<>();
            needsPolice.put(Needs.FOOD, -10);
            needsPolice.put(Needs.WATER, 0);
            needsPolice.put(Needs.ENTERTAINMENT, -10);
            needsPolice.put(Needs.COMMUNICATION, 15);
            needsPolice.put(Needs.HEALTHY, -10);
            needsPolice.put(Needs.TOILET, -10);
            create(new Profession("police", 600, 480, needsPolice));
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
    public Profession create(Profession entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public Profession update(Profession entity) {
        Optional<Profession> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            Profession professionForUpdate = optional.get();
            professionForUpdate.setTime(entity.getTime());
            professionForUpdate.setNeeds(entity.getNeeds());
            professionForUpdate.setIncome(entity.getIncome());
            return professionForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(Profession entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<Profession> findAll() {
        return set;
    }

    public Profession findByName(String name) {
        for (Profession x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }
}
