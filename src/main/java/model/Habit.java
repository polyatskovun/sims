package model;

import enums.Needs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
@Builder
public class Habit {

    private String name;
    private Map<Needs, Integer> needs;

}
