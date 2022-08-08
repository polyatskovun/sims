package dto;

import enums.Age;
import enums.Needs;
import enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import model.Case;
import model.Habit;
import model.Profession;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class ModelInsertDto {

    private String name;
    private Age age;
    private Sex sex;
    private int money;
    private Map<Needs, Integer> needs;
    private Set<Habit> habits;
    private Profession profession;
    private Case roundCase;
}
