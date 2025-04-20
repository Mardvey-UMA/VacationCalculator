package neoflex.task.vacationcalculator.controller;

import lombok.RequiredArgsConstructor;
import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.exception.InvalidRequestException;
import neoflex.task.vacationcalculator.service.interfaces.VacationCalculationOrchestrator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class VacationSalaryCalculatorController {

    private final VacationCalculationOrchestrator vacationCalculationOrchestrator;

    @GetMapping()
    public CalculateVacationResponseDTO getVacationSalary(
            @RequestParam Double avgSalary,
            @RequestParam(required = false) Integer vacationDays,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return vacationCalculationOrchestrator.calculateVacation(avgSalary, vacationDays, startDate, endDate);
    }
}
