package neoflex.task.vacationcalculator;

import neoflex.task.vacationcalculator.exception.InvalidAverageSalaryException;
import neoflex.task.vacationcalculator.exception.InvalidVacationDateException;
import neoflex.task.vacationcalculator.exception.InvalidVacationDaysException;
import neoflex.task.vacationcalculator.service.implementation.VacationCalculationOrchestratorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class VacationCalculationOrchestratorExceptionTest {
    @InjectMocks
    private VacationCalculationOrchestratorImpl vacationCalculationOrchestrator;

    @Test
    void calculateVacation_WhenSalaryIsNull_ThrowsInvalidAverageSalaryException() {
        assertThrows(InvalidAverageSalaryException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(null, 10, null, null));
    }

    @Test
    void calculateVacation_WhenSalaryIsZero_ThrowsInvalidAverageSalaryException() {
        assertThrows(InvalidAverageSalaryException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(0.0, 10, null, null));
    }

    @Test
    void calculateVacation_WhenSalaryIsNegative_ThrowsInvalidAverageSalaryException() {
        assertThrows(InvalidAverageSalaryException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(-1000.0, 10, null, null));
    }

    @Test
    void calculateVacation_WhenBothDaysAndDatesAreNull_ThrowsInvalidVacationDaysException() {
        assertThrows(InvalidVacationDaysException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(1000.0, null, null, null));
    }

    @Test
    void calculateVacation_WhenDaysIsZero_ThrowsInvalidVacationDaysException() {
        assertThrows(InvalidVacationDaysException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(1000.0, 0, null, null));
    }

    @Test
    void calculateVacation_WhenDaysIsNegative_ThrowsInvalidVacationDaysException() {
        assertThrows(InvalidVacationDaysException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(1000.0, -5, null, null));
    }

    @Test
    void calculateVacation_WhenEndDateBeforeStartDate_ThrowsInvalidVacationDateException() {
        LocalDate start = LocalDate.now();
        LocalDate end = start.minusDays(1);

        assertThrows(InvalidVacationDateException.class,
                () -> vacationCalculationOrchestrator
                        .calculateVacation(1000.0, null, start, end));
    }
}