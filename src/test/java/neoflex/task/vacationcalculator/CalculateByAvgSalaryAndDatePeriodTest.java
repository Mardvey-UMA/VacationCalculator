package neoflex.task.vacationcalculator;

import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.service.implementation.CalculateVacationPayoutServiceImpl;
import neoflex.task.vacationcalculator.service.interfaces.WorkingDaysCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateByAvgSalaryAndDatePeriodTest {
    @Mock
    private WorkingDaysCalculationService workingDaysCalculationService;

    @InjectMocks
    private CalculateVacationPayoutServiceImpl calculateVacationPayoutService;

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test1() {
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 14);

        when(workingDaysCalculationService.getVacationDaysCount(startDate, endDate)).thenReturn(8);

        double avgSalary = 100_000.0;

        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(27303.75);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService.calculateVacationPayout(avgSalary, startDate, endDate);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test2() {
        LocalDate startDate = LocalDate.of(2025, 2, 23);
        LocalDate endDate = LocalDate.of(2025, 3, 3);

        when(workingDaysCalculationService.getVacationDaysCount(startDate, endDate)).thenReturn(5);

        double avgSalary = 120_000.0;

        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(20477.82);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, startDate, endDate);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test3() {
        LocalDate startDate = LocalDate.of(2025, 4, 28);
        LocalDate endDate = LocalDate.of(2025, 5, 12);

        when(workingDaysCalculationService.getVacationDaysCount(startDate, endDate)).thenReturn(9);

        double avgSalary = 85_000.0;

        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(26109.22);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, startDate, endDate);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test4() {
        LocalDate startDate = LocalDate.of(2025, 6, 9);
        LocalDate endDate = LocalDate.of(2025, 6, 20);

        when(workingDaysCalculationService.getVacationDaysCount(startDate, endDate)).thenReturn(9);

        double avgSalary = 150_000.0;

        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(46075.09);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, startDate, endDate);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test5() {
        LocalDate startDate = LocalDate.of(2025, 11, 3);
        LocalDate endDate = LocalDate.of(2025, 11, 7);

        when(workingDaysCalculationService.getVacationDaysCount(startDate, endDate)).thenReturn(4);

        double avgSalary = 200_000.0;

        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(27303.75);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, startDate, endDate);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }
}
