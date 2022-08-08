package repository.impl;


import enums.Needs;
import model.Case;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaseRepositoryImplTest {

    @org.junit.jupiter.api.Test
    void create() {
        CaseRepositoryImpl repository = CaseRepositoryImpl.getInstance(false);
        Map<Needs, Integer> needsSuccessful= new HashMap<>();
        needsSuccessful.put(Needs.COMMUNICATION, 30);
        needsSuccessful.put(Needs.ENTERTAINMENT, 20);
        Map<Needs, Integer> needsUnsuccessful =new HashMap<>();
        needsUnsuccessful.put(Needs.COMMUNICATION, 5);
        needsUnsuccessful.put(Needs.ENTERTAINMENT, -10);
        Case Meet = new Case("Meet", 30, needsSuccessful, needsUnsuccessful );

        repository.create(Meet);
        
        assertEquals(1, repository.getSet().size());
        assertEquals(30, repository.getSet().iterator().next().getTime());

    }

    @org.junit.jupiter.api.Test
    void update() {
        CaseRepositoryImpl repository = CaseRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsSuccessful= new HashMap<>();
        needsSuccessful.put(Needs.COMMUNICATION, 30);
        needsSuccessful.put(Needs.ENTERTAINMENT, 20);
        Map<Needs, Integer> needsUnsuccessful =new HashMap<>();
        needsUnsuccessful.put(Needs.COMMUNICATION, 5);
        needsUnsuccessful.put(Needs.ENTERTAINMENT, -10);
        Case Meet = new Case("Meet", 50, needsSuccessful, needsUnsuccessful );

        repository.update(Meet);

        assertEquals(50, repository.getSet().iterator().next().getTime());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        CaseRepositoryImpl repository = CaseRepositoryImpl.getInstance(true);
        Map<Needs, Integer> needsSuccessful= new HashMap<>();
        needsSuccessful.put(Needs.COMMUNICATION, 30);
        needsSuccessful.put(Needs.ENTERTAINMENT, 20);
        Map<Needs, Integer> needsUnsuccessful =new HashMap<>();
        needsUnsuccessful.put(Needs.COMMUNICATION, 5);
        needsUnsuccessful.put(Needs.ENTERTAINMENT, -10);
        Case Meet = new Case("Meet", 50, needsSuccessful, needsUnsuccessful );

        repository.delete(Meet);

        assertEquals(0, repository.getSet().size());
    }

    @org.junit.jupiter.api.Test
    void findAll() {
        CaseRepositoryImpl repository = CaseRepositoryImpl.getInstance(true);

        Set <Case> setCase = repository.findAll();

        assertEquals(1, setCase.size());
        assertEquals(30, repository.getSet().iterator().next().getTime());
    }

    @org.junit.jupiter.api.Test
    void findByName() {
        CaseRepositoryImpl repository = CaseRepositoryImpl.getInstance(true);

        Case caseMeet = repository.findByName("Meet");

        assertEquals(30, repository.getSet().iterator().next().getTime());
    }
}