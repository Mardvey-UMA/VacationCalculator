package neoflex.task.vacationcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculateVacationResponseDTO {
    Double expectedPayout;

    public Double getPayout() {
        return this.expectedPayout;
    }
}
