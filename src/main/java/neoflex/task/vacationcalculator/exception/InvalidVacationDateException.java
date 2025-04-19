package neoflex.task.vacationcalculator.exception;

public class InvalidVacationDateException extends RuntimeException {
    public InvalidVacationDateException() {
        super("Дата окончания отпуска не может быть раньше даты старта отпуска");
    }
}
