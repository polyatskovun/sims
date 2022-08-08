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
public class HabitEntity {

    private String name;
    private Map<Needs, Integer> needs;

}
