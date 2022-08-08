package dto;

import enums.Needs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
@Builder
public class CaseDto {

    private String name;
    private int time;
    private Map<Needs, Integer> needsSuccessful;
    private Map<Needs, Integer> needsUnsuccessful;

}
