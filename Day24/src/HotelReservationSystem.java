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

    public Hotel findCheapestBestRatedHotel(List<LocalDate> dates) {

        Map<Hotel, Integer> costMap = new HashMap<>();

        for (Hotel hotel : hotels) {

            int totalCost = 0;

            for (LocalDate date : dates) {

                DayOfWeek day = date.getDayOfWeek();

                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                    totalCost += hotel.regularWeekendRate;
                } else {
                    totalCost += hotel.regularWeekdayRate;
                }
            }

            costMap.put(hotel, totalCost);
        }

        int minCost = Collections.min(costMap.values());

        List<Hotel> cheapestHotels = new ArrayList<>();

        for (Map.Entry<Hotel, Integer> entry : costMap.entrySet()) {

            if (entry.getValue() == minCost) {
                cheapestHotels.add(entry.getKey());
            }
        }

        return cheapestHotels.stream()
                .max(Comparator.comparingInt(h -> h.ratings))
                .orElse(null);
    }
}
