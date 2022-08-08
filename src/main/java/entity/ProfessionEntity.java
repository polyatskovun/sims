package entity;

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
public class ProfessionEntity {

    private String name;
    private int income;
    private int time;
    private Map<Needs, Integer> needs;


}
