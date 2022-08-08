package repository.impl;

import entity.HabitEntity;
import entity.ModelEntity;
import enums.Age;
import enums.Needs;
import enums.Sex;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.ModelRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelRepositoryImpl implements ModelRepository {

    private static ModelRepositoryImpl instance;
    Set<ModelEntity> set = new HashSet<>();
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
            Set<HabitEntity> set1 = new HashSet<>();
            create(new ModelEntity(null, "Alex", Age.ADULT, Sex.MAN, 200, needsAlex, set1, null, null));

            Map<Needs, Integer> needsPeter = new HashMap<>();
            needsPeter.put(Needs.FOOD, 100);
            needsPeter.put(Needs.WATER, 100);
            needsPeter.put(Needs.TOILET, 100);
            needsPeter.put(Needs.COMMUNICATION, 100);
            needsPeter.put(Needs.ENTERTAINMENT, 100);
            needsPeter.put(Needs.HEALTHY, 100);
            Set<HabitEntity> set2 = new HashSet<>();
            create(new ModelEntity(null, "Peter", Age.ADULT, Sex.MAN, 350, needsPeter, set2, null, null));
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
    public ModelEntity create(ModelEntity entity) {
        set.add(entity);
        if (entity.getId() == null) {
            entity.setId(createID());
        }
        return entity;
    }

    @Override
    public ModelEntity update(ModelEntity entity) {
        Optional<ModelEntity> modelUpdate = set.stream().filter(x -> x.getId().equals(entity.getId())).findFirst();
        if (modelUpdate.isPresent()) {
            ModelEntity modelEntity = modelUpdate.get();
            modelEntity.setAge(entity.getAge());
            modelEntity.setName(entity.getName());
            modelEntity.setHabitEntities(entity.getHabitEntities());
            modelEntity.setNeeds(entity.getNeeds());
            modelEntity.setMoney(entity.getMoney());
            modelEntity.setProfessionEntity(entity.getProfessionEntity());
            modelEntity.setSex(entity.getSex());
            modelEntity.setRoundCaseEntity(entity.getRoundCaseEntity());
            return modelEntity;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(ModelEntity entity) {
        set = set.stream().filter(x -> !x.getId().equals(entity.getId())).collect(Collectors.toSet());
    }

    @Override
    public Set<ModelEntity> findAll() {
        return set;
    }


    public ModelEntity findByName(String name) {
        for (ModelEntity x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    private ModelEntity findById(Integer id) {
        for (ModelEntity x : set) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

}
