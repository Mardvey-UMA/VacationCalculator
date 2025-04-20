package neoflex.task.vacationcalculator.exception;

public class ErrorWithHolidaysDaysAPI extends RuntimeException {
    public ErrorWithHolidaysDaysAPI() {
        super("Ошибка при выполнении запроса к внешнему API");
    }
}
