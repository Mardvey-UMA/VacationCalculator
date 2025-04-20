package neoflex.task.vacationcalculator;

import neoflex.task.vacationcalculator.exception.InvalidVacationDateException;
import neoflex.task.vacationcalculator.repository.HolidayCache;
import neoflex.task.vacationcalculator.service.implementation.WorkingDaysCalculationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkingDaysCalculationServiceTest {

    @Mock
    private HolidayCache holidayCache;

    @InjectMocks
    private WorkingDaysCalculationServiceImpl workingDaysService;

    private Set<LocalDate> holidaysList2025() {
        return Set.of(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 2),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 1, 4),
                LocalDate.of(2025, 1, 5),
                LocalDate.of(2025, 1, 6),
                LocalDate.of(2025, 1, 7),
                LocalDate.of(2025, 2, 23),
                LocalDate.of(2025, 3, 8),
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 5, 9),
                LocalDate.of(2025, 6, 12),
                LocalDate.of(2025, 11, 4)
        );
    }

    private Set<LocalDate> holidaysList2026() {
        return Set.of(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 2),
                LocalDate.of(2026, 1, 3),
                LocalDate.of(2026, 1, 4),
                LocalDate.of(2026, 1, 5),
                LocalDate.of(2026, 1, 6),
                LocalDate.of(2026, 1, 7),
                LocalDate.of(2026, 2, 23),
                LocalDate.of(2026, 3, 8),
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 9),
                LocalDate.of(2026, 6, 12),
                LocalDate.of(2026, 11, 4)
        );
    }

    @Test
    void getVacationDaysCount_Test1() {
        when(holidayCache.getHolidays(2025)).thenReturn(holidaysList2025());
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 10);

        int result = workingDaysService.getVacationDaysCount(startDate, endDate);

        assertEquals(3, result);
    }

    @Test
    void getVacationDaysCount_Test2() {
        when(holidayCache.getHolidays(2025)).thenReturn(holidaysList2025());
        LocalDate startDate = LocalDate.of(2025, 2, 1);
        LocalDate endDate = LocalDate.of(2025, 2, 14);

        int result = workingDaysService.getVacationDaysCount(startDate, endDate);

        assertEquals(10, result);
    }

    @Test
    void getVacationDaysCount_Test3() {
        when(holidayCache.getHolidays(2025)).thenReturn(holidaysList2025());
        LocalDate startDate = LocalDate.of(2025, 5, 1);
        LocalDate endDate = LocalDate.of(2025, 5, 10);

        int result = workingDaysService.getVacationDaysCount(startDate, endDate);

        assertEquals(5, result);
    }

    @Test
    void getVacationDaysCount_Test4() {
        when(holidayCache.getHolidays(2025)).thenReturn(holidaysList2025());
        LocalDate startDate = LocalDate.of(2025, 6, 5);
        LocalDate endDate = LocalDate.of(2025, 6, 15);

        int result = workingDaysService.getVacationDaysCount(startDate, endDate);

        assertEquals(6, result);
    }

    @Test
    void getVacationDaysCount_Test5() {
        when(holidayCache.getHolidays(2025)).thenReturn(holidaysList2025());
        when(holidayCache.getHolidays(2026)).thenReturn(holidaysList2026());
        LocalDate startDate = LocalDate.of(2025, 12, 28);
        LocalDate endDate = LocalDate.of(2026, 1, 11);

        int result = workingDaysService.getVacationDaysCount(startDate, endDate);

        assertEquals(5, result);
    }

    @Test
    void getVacationDaysCount_WhenEndDateBeforeStartDate_ThrowsInvalidVacationDateException() {
        LocalDate startDate = LocalDate.of(2025, 1, 10);
        LocalDate endDate = LocalDate.of(2025, 1, 1);

        assertThrows(
                InvalidVacationDateException.class,
                () -> workingDaysService.getVacationDaysCount(startDate, endDate)
        );
    }
}
