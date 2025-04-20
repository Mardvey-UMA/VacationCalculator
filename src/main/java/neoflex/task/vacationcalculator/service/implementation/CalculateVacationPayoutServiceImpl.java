package neoflex.task.vacationcalculator.service.implementation;

import lombok.RequiredArgsConstructor;
import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.service.interfaces.CalculateVacationPayoutService;
import neoflex.task.vacationcalculator.service.interfaces.WorkingDaysCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class CalculateVacationPayoutServiceImpl implements CalculateVacationPayoutService {

    private final WorkingDaysCalculationService workingDaysCalculationService;
    private static final double AVG_DAYS_IN_MONTH = 29.3;

    @Override
    public CalculateVacationResponseDTO calculateVacationPayout(double avgSalary, int numberOfDays) {
        BigDecimal expectedPayout = BigDecimal.valueOf(avgSalary / AVG_DAYS_IN_MONTH * numberOfDays).setScale(2, RoundingMode.HALF_UP);
        return new CalculateVacationResponseDTO(expectedPayout);
    }

    @Override
    public CalculateVacationResponseDTO calculateVacationPayout(double avgSalary, LocalDate startDate, LocalDate endDate) {
        int numberOfDays = workingDaysCalculationService.getVacationDaysCount(startDate, endDate);
        BigDecimal expectedPayout = BigDecimal.valueOf(avgSalary / AVG_DAYS_IN_MONTH * numberOfDays).setScale(2, RoundingMode.HALF_UP);
        return new CalculateVacationResponseDTO(expectedPayout);
    }
}
