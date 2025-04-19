package neoflex.task.vacationcalculator.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class HolidayDTO {
    private final String date;

    @JsonCreator
    public HolidayDTO(@JsonProperty("date") String date) {
        this.date = date;
    }

}