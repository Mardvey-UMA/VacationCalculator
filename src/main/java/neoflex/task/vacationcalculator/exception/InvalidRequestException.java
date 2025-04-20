package neoflex.task.vacationcalculator.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Не хватает параметров для запроса." +
                "Для расчета отпускной выплаты по количеству дней: " +
                "avgSalary = {Ваша средняя зарплата}, vacationDays = {Кол-во дней в отпуске}" +
                "Для расчета зарплаты по датам отпуска: " +
                "avgSalary = {Ваша средняя зарплата}, " +
                "startDate, endDate = {Дата старта и окончания отпуска в формате \"dd-MM-yyyy\"");
    }
}
