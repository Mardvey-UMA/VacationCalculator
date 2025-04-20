package neoflex.task.vacationcalculator;

import neoflex.task.vacationcalculator.dto.CalculateVacationResponseDTO;
import neoflex.task.vacationcalculator.service.implementation.CalculateVacationPayoutServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateByAvgSalaryAndDaysTest {

    @InjectMocks
    private CalculateVacationPayoutServiceImpl calculateVacationPayoutService;

    @Test
    void testCalculateByAvgSalaryAndDatePeriod_Test1() {
        double avgSalary = 100_000.0;
        int days = 8;
        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(27303.75);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, days);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDays_Test2() {
        double avgSalary = 1.0;
        int days = 1;
        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(0.03);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, days);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDays_Test3() {
        double avgSalary = 250_000.0;
        int days = 14;
        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(119453.92);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, days);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDays_Test4() {
        double avgSalary = 80_000.0;
        int days = 7;
        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(19112.63);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, days);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }

    @Test
    void testCalculateByAvgSalaryAndDays_Test5() {
        double avgSalary = 150_000.0;
        int days = 28;
        CalculateVacationResponseDTO expected = new CalculateVacationResponseDTO(143344.71);

        CalculateVacationResponseDTO actual = calculateVacationPayoutService
                .calculateVacationPayout(avgSalary, days);

        assertEquals(expected.getPayout(), actual.getPayout(), 0.01);
    }
}