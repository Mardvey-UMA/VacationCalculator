package neoflex.task.vacationcalculator.exception;

public class InvalidAverageSalaryException extends RuntimeException{
    public InvalidAverageSalaryException() {
        super("Зарплата не может быть отрицательной или нулевой");
    }
}
