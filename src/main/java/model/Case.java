package model;

import enums.Needs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Case {

    private String name;
    private int time;
    private Map<Needs, Integer> needsSuccessful;
    private Map<Needs, Integer> needsUnsuccessful;

}
