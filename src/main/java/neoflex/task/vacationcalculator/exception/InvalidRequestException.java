package neoflex.task.vacationcalculator.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Не хватает параметров для запроса. \nДля расчета отпускной выплаты по количеству дней" +
                "\navgSalary = {Ваша средняя зарплата}, vacationDays = {Кол-во дней в отпуске}" +
                "\nДля расчета зарплаты по датам отпуска" +
                "\navgSalary = {Ваша средняя зарплата}, startDate, endDate = {Дата старта и окончания отпуска в формате \"dd-MM-yyyy\"");
    }
}
