package repository.impl;

import enums.Age;
import enums.Needs;
import enums.Sex;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Habit;
import model.Model;
import repository.ModelRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelRepositoryImpl implements ModelRepository {

    private static ModelRepositoryImpl instance;
    Set<Model> set = new HashSet<>();
    private Integer idCounter = 1;

    private ModelRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsAlex = new HashMap<>();
            needsAlex.put(Needs.FOOD, 100);
            needsAlex.put(Needs.WATER, 100);
            needsAlex.put(Needs.TOILET, 100);
            needsAlex.put(Needs.COMMUNICATION, 100);
            needsAlex.put(Needs.ENTERTAINMENT, 100);
            needsAlex.put(Needs.HEALTHY, 100);
            Set<Habit> set1 = new HashSet<>();
            create(new Model("Alex", Age.ADULT, Sex.MAN, 200, needsAlex, set1, null, null));

            Map<Needs, Integer> needsPeter = new HashMap<>();
            needsPeter.put(Needs.FOOD, 100);
            needsPeter.put(Needs.WATER, 100);
            needsPeter.put(Needs.TOILET, 100);
            needsPeter.put(Needs.COMMUNICATION, 100);
            needsPeter.put(Needs.ENTERTAINMENT, 100);
            needsPeter.put(Needs.HEALTHY, 100);
            Set<Habit> set2 = new HashSet<>();
            create(new Model("Peter", Age.ADULT, Sex.MAN, 350, needsPeter, set2, null, null));
        }
    }

    public static ModelRepositoryImpl getInstance(boolean isInitDefaultData) {
        if (instance == null) {
            instance = new ModelRepositoryImpl(isInitDefaultData);
        }
        return instance;
    }

    public static ModelRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ModelRepositoryImpl();
        }
        return instance;
    }

    private Integer createID() {
        return idCounter++;
    }

    @Override
    public Model create(Model entity) {
        set.add(entity);
        if (entity.getId() == null) {
            entity.setId(createID());
        }
        return entity;
    }

    @Override
    public Model update(Model entity) {
        Optional<Model> modelUpdate = set.stream().filter(x -> x.getId().equals(entity.getId())).findFirst();
        if (modelUpdate.isPresent()) {
            Model model = modelUpdate.get();
            model.setAge(entity.getAge());
            model.setName(entity.getName());
            model.setHabits(entity.getHabits());
            model.setNeeds(entity.getNeeds());
            model.setMoney(entity.getMoney());
            model.setProfession(entity.getProfession());
            model.setSex(entity.getSex());
            model.setRoundCase(entity.getRoundCase());
            return model;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(Model entity) {
        set = set.stream().filter(x -> !x.getId().equals(entity.getId())).collect(Collectors.toSet());
    }

    @Override
    public Set<Model> findAll() {
        return set;
    }


    public Model findByName(String name) {
        for (Model x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    private Model findById(Integer id) {
        for (Model x : set) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

}
