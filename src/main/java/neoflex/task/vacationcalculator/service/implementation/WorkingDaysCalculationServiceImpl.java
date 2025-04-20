package neoflex.task.vacationcalculator.service.implementation;

import lombok.RequiredArgsConstructor;
import neoflex.task.vacationcalculator.exception.InvalidVacationDateException;
import neoflex.task.vacationcalculator.repository.HolidayCache;
import neoflex.task.vacationcalculator.service.interfaces.WorkingDaysCalculationService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WorkingDaysCalculationServiceImpl implements WorkingDaysCalculationService {

    private final HolidayCache holidayCache;

    @Override
    public int getVacationDaysCount(LocalDate startDate, LocalDate endDate) {

        if (endDate.isBefore(startDate)) {
            throw new InvalidVacationDateException();
        }

        int totalDays = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            if (!isWeekend(currentDate) && !isHoliday(currentDate)) {
                totalDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return totalDays;
    }

    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate date) {
        int year = date.getYear();
        Set<LocalDate> holidays = holidayCache.getHolidays(year);
        LocalDate apiFormatDate = LocalDate.parse(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return holidays.contains(apiFormatDate);
    }
}
