package neoflex.task.vacationcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Data
@AllArgsConstructor
public class CalculateVacationResponseDTO {
    BigDecimal expectedPayout;
}
