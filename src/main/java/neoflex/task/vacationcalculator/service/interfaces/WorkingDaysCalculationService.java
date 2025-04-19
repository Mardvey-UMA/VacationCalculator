package neoflex.task.vacationcalculator.service.interfaces;

import java.time.LocalDate;

public interface WorkingDaysCalculationService {
    int getVacationDaysCount(LocalDate startDate, LocalDate endDate);
}
