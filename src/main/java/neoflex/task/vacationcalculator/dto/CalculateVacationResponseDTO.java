package neoflex.task.vacationcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculateVacationResponseDTO {
    Integer numberOfDays;
    Integer numberOfOfficialHolidays;
    Float expectedPayout;
}
