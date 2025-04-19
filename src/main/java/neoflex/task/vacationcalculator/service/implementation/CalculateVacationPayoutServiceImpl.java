package neoflex.task.vacationcalculator.service.implementation;

import lombok.RequiredArgsConstructor;
import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.service.interfaces.CalculateVacationPayoutService;
import neoflex.task.vacationcalculator.service.interfaces.WorkingDaysCalculationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class CalculateVacationPayoutServiceImpl implements CalculateVacationPayoutService {

    private final WorkingDaysCalculationService workingDaysCalculationService;
    private static final float AVG_DAYS_IN_MONTH = 29.3f;

    @Override
    public CalculateVacationResponseDTO calculateVacationPayout(float avgSalary, int numberOfDays) {
        float payout = avgSalary / AVG_DAYS_IN_MONTH * numberOfDays;
        return new CalculateVacationResponseDTO(numberOfDays, null, payout);
    }

    @Override
    public CalculateVacationResponseDTO calculateVacationPayout(float avgSalary, LocalDate startDate, LocalDate endDate) {
        int numberOfDays = workingDaysCalculationService.getVacationDaysCount(startDate, endDate);
        int vacationDaysCount = Period.between(startDate, endDate).getDays() + 1;
        float payout = avgSalary / AVG_DAYS_IN_MONTH * numberOfDays;
        return new CalculateVacationResponseDTO(numberOfDays, vacationDaysCount - numberOfDays, payout);
    }
}
