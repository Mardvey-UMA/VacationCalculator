package neoflex.task.vacationcalculator.service.interfaces;

import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;

import java.time.LocalDate;

public interface CalculateVacationPayoutService {
    CalculateVacationResponseDTO calculateVacationPayout(float avgSalary, int numberOfDays);
    CalculateVacationResponseDTO calculateVacationPayout(float avgSalary, LocalDate startDate, LocalDate endDate);
}
