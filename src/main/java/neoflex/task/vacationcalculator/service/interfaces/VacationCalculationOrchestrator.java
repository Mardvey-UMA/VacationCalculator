package neoflex.task.vacationcalculator.service.interfaces;

import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;

import java.time.LocalDate;

public interface VacationCalculationOrchestrator {
    CalculateVacationResponseDTO calculateVacation(       Double avgSalary,
                                                          Integer vacationDays,
                                                          LocalDate startDate,
                                                          LocalDate endDate);
}
