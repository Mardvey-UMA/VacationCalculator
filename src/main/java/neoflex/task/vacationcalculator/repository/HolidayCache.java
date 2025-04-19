package neoflex.task.vacationcalculator.repository;

import neoflex.task.vacationcalculator.dto.HolidayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class HolidayCache {
    private final String baseApiUrl;
    private final String countryCode;
    private final int startYear;
    private final int endYear;
    private final RestTemplate restTemplate;

    @Autowired
    public HolidayCache(
            @Value("${app.api.base-url}") String baseApiUrl,
            @Value("${app.api.country-code}") String countryCode,
            @Value("${app.api.start-year}") int startYear,
            @Value("${app.api.end-year}") int endYear,
            RestTemplate restTemplate
    ) {
        this.baseApiUrl = baseApiUrl;
        this.countryCode = countryCode;
        this.startYear = startYear;
        this.endYear = endYear;
        this.restTemplate = restTemplate;
    }

    private final Map<Integer, Set<LocalDate>> holidays = new HashMap<>();

    @PostConstruct
    public void init() {
        loadHolidaysForYears(startYear, endYear);
    }

    private void loadHolidaysForYears(int startYear, int endYear) {
        for (int year = startYear; year <= endYear; year++) {
            fetchAndStoreHolidays(year);
        }
    }

    public Set<LocalDate> getHolidays(int year) {
        return holidays.computeIfAbsent(year, k -> {
            fetchAndStoreHolidays(year);
            return holidays.get(year);
        });
    }

    private void fetchAndStoreHolidays(int year) {
        try {
            String url = String.format("%s/%d/%s", baseApiUrl, year, countryCode);
            HolidayDTO[] response = restTemplate.getForObject(url, HolidayDTO[].class);

            if (response != null) {
                Set<LocalDate> dates = new HashSet<>();
                for (HolidayDTO holiday : response) {
                    dates.add(LocalDate.parse(holiday.getDate()));
                }
                holidays.put(year, dates);
            }
        } catch (Exception e) {
            System.err.println("Error with API: " + e.getMessage());
        }
    }
}
