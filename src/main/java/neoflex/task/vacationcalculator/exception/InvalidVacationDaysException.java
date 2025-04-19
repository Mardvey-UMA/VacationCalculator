package neoflex.task.vacationcalculator.exception;

public class InvalidVacationDaysException extends RuntimeException {
    public InvalidVacationDaysException() {
        super("Количество дней отпуска не может быть отрицательным");
    }
}
