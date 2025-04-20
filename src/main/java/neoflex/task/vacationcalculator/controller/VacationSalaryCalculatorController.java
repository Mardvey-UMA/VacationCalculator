package neoflex.task.vacationcalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Vacation Calculator", description = "API для расчета отпускных")
public class VacationSalaryCalculatorController {

    private final VacationCalculationOrchestrator vacationCalculationOrchestrator;

    @Operation(summary = "Рассчитать отпускные", description = "Расчет по дням или датам")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешный расчет"),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public CalculateVacationResponseDTO getVacationSalary(
            @Parameter(description = "Средняя зарплата", required = true, example = "100000")
            @RequestParam Double avgSalary,

            @Parameter(description = "Количество дней отпуска")
            @RequestParam(required = false) Integer vacationDays,

            @Parameter(description = "Дата начала (dd-MM-yyyy)", example = "01-01-2025")
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,

            @Parameter(description = "Дата окончания (dd-MM-yyyy)", example = "14-01-2025")
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        return vacationCalculationOrchestrator.calculateVacation(avgSalary, vacationDays, startDate, endDate);
    }
}
