package neoflex.task.vacationcalculator.service.implementation;

import lombok.RequiredArgsConstructor;
import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.exception.InvalidAverageSalaryException;
import neoflex.task.vacationcalculator.exception.InvalidVacationDateException;
import neoflex.task.vacationcalculator.exception.InvalidVacationDaysException;
import neoflex.task.vacationcalculator.service.interfaces.CalculateVacationPayoutService;
import neoflex.task.vacationcalculator.service.interfaces.VacationCalculationOrchestrator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VacationCalculationOrchestratorImpl implements VacationCalculationOrchestrator {

    private final CalculateVacationPayoutService calculateVacationPayoutService;

    @Override
    public CalculateVacationResponseDTO calculateVacation(Float avgSalary, Integer vacationDays, LocalDate startDate, LocalDate endDate) {
        if (avgSalary == null || avgSalary <= 0) {
            throw new InvalidAverageSalaryException();
        }

        if (vacationDays == null && (startDate == null || endDate == null)) {
            throw new InvalidVacationDaysException();
        }

        if (startDate != null && endDate != null) {
            if (startDate.isAfter(endDate)) {
                throw new InvalidVacationDateException();
            }
        }

        if (vacationDays != null) {
            if (vacationDays <= 0) {
                throw new InvalidVacationDaysException();
            }
            return calculateVacationPayoutService.calculateVacationPayout(avgSalary, vacationDays);
        } else {
            return calculateVacationPayoutService.calculateVacationPayout(avgSalary, startDate, endDate);
        }
    }
}
