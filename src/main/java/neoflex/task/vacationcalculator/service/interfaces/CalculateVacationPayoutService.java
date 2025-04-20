package neoflex.task.vacationcalculator.service.interfaces;

import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;

import java.time.LocalDate;

public interface CalculateVacationPayoutService {
    CalculateVacationResponseDTO calculateVacationPayout(double avgSalary, int numberOfDays);
    CalculateVacationResponseDTO calculateVacationPayout(double avgSalary, LocalDate startDate, LocalDate endDate);
}
