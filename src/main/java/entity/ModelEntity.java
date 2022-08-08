package entity;

import enums.Age;
import enums.Needs;
import enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ModelEntity {

    private Integer id;
    private String name;
    private Age age;
    private Sex sex;
    private int money;
    private Map<Needs, Integer> needs;
    private Set<HabitEntity> habitEntities;
    private ProfessionEntity professionEntity;
    private CaseEntity roundCaseEntity;


}
