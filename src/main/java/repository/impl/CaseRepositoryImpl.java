package repository.impl;

import entity.CaseEntity;
import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repository.CaseRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CaseRepositoryImpl implements CaseRepository {

    private static CaseRepositoryImpl instance;
    Set<CaseEntity> set = new HashSet<>();

    private CaseRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsSuccessful = new HashMap<>();
            needsSuccessful.put(Needs.COMMUNICATION, 30);
            needsSuccessful.put(Needs.ENTERTAINMENT, 20);
            Map<Needs, Integer> needsUnsuccessful = new HashMap<>();
            needsUnsuccessful.put(Needs.COMMUNICATION, 5);
            needsUnsuccessful.put(Needs.ENTERTAINMENT, -10);
            create(new CaseEntity("Meet", 30, needsSuccessful, needsUnsuccessful));
        }
    }

    public static CaseRepositoryImpl getInstance(boolean isInitDefaultData) {
        if (instance == null) {
            instance = new CaseRepositoryImpl(isInitDefaultData);
        }
        return instance;
    }

    public static CaseRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CaseRepositoryImpl();
        }
        return instance;
    }


    @Override
    public CaseEntity create(CaseEntity entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public CaseEntity update(CaseEntity entity) {
        Optional<CaseEntity> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            CaseEntity caseEntityForUpdate = optional.get();
            caseEntityForUpdate.setTime(entity.getTime());
            caseEntityForUpdate.setNeedsSuccessful(entity.getNeedsSuccessful());
            caseEntityForUpdate.setNeedsUnsuccessful(entity.getNeedsUnsuccessful());
            return caseEntityForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(CaseEntity entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<CaseEntity> findAll() {
        return set;
    }

    public CaseEntity findByName(String name) {
        for (CaseEntity x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }


}
