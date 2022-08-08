package repository.impl;

import enums.Needs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Case;
import repository.CaseRepository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CaseRepositoryImpl implements CaseRepository {

    private static CaseRepositoryImpl instance;
    Set<Case> set = new HashSet<>();

    private CaseRepositoryImpl(boolean isInitDefaultData) {
        if (isInitDefaultData) {
            Map<Needs, Integer> needsSuccessful = new HashMap<>();
            needsSuccessful.put(Needs.COMMUNICATION, 30);
            needsSuccessful.put(Needs.ENTERTAINMENT, 20);
            Map<Needs, Integer> needsUnsuccessful = new HashMap<>();
            needsUnsuccessful.put(Needs.COMMUNICATION, 5);
            needsUnsuccessful.put(Needs.ENTERTAINMENT, -10);
            create(new Case("Meet", 30, needsSuccessful, needsUnsuccessful));
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
    public Case create(Case entity) {
        set.add(entity);
        return entity;
    }

    @Override
    public Case update(Case entity) {
        Optional<Case> optional = set.stream().filter(x -> x.getName().equals(entity.getName())).findFirst();
        if (optional.isPresent()) {
            Case caseForUpdate = optional.get();
            caseForUpdate.setTime(entity.getTime());
            caseForUpdate.setNeedsSuccessful(entity.getNeedsSuccessful());
            caseForUpdate.setNeedsUnsuccessful(entity.getNeedsUnsuccessful());
            return caseForUpdate;
        } else {
            return create(entity);
        }
    }

    @Override
    public void delete(Case entity) {
        set = set.stream().filter(x -> !x.getName().equals(entity.getName())).collect(Collectors.toSet());
    }

    @Override
    public Set<Case> findAll() {
        return set;
    }

    public Case findByName(String name) {
        for (Case x : set) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }


}
