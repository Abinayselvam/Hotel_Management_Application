import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {
    public static int[] getWeekdayWeekendCount(LocalDate start, LocalDate end) {

        int weekdays = 0;
        int weekends = 0;

        while (!start.isAfter(end)) {

            DayOfWeek day = start.getDayOfWeek();

            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                weekends++;
            } else {
                weekdays++;
            }

            start = start.plusDays(1);
        }

        return new int[]{weekdays, weekends};
    }
}
