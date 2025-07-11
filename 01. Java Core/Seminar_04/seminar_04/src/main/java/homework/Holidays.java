package homework;

import lombok.Getter;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@Getter
public enum Holidays {
    NEW_YEAR(LocalDate.of(LocalDate.now().getYear(), 12, 31)),
    MARCH_8(LocalDate.of(LocalDate.now().getYear(), 3, 8)),
    FEBRUARY_23(LocalDate.of(LocalDate.now().getYear(), 2, 23));


    private final LocalDate holiday;

    Holidays(LocalDate holiday) {
        this.holiday = holiday;
    }
}
