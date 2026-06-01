import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;

public class HotelReservationSystem {
    ArrayList<Hotel> hotels=new ArrayList<>();
    public void addHotel(Hotel hotel)
    {
        hotels.add(hotel);
        System.out.println("Hotel Added Successfully");
    }
    public void displayHotel()
    {
        System.out.println("Available Hotels");
        for (Hotel h:hotels)
        {
            System.out.println("Hotel Name: "+h.getName()+" | "+" Regular Week day: "+h.regularWeekdayRate+" | "+" Regular Week end: "+h.regularWeekendRate);
        }
    }

    public Hotel findCheapestBestRated(int weekdayCount, int weekendCount) {

        return hotels.stream()
                .min((h1, h2) -> {

                    int cost1 = h1.calculateTotalCost(weekdayCount, weekendCount);
                    int cost2 = h2.calculateTotalCost(weekdayCount, weekendCount);

                    if (cost1 == cost2) {
                        return Integer.compare(h2.ratings, h1.ratings); // higher rating wins
                    }

                    return Integer.compare(cost1, cost2); // cheaper wins
                })
                .orElse(null);
    }
}
