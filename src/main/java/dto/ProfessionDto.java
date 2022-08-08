package dto;

import enums.Needs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
@Builder
public class ProfessionDto {

    private String name;
    private int income;
    private int time;
    private Map<Needs, Integer> needs;
}
