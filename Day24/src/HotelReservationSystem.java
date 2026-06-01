import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public Hotel findCheapestHotel(LocalDate start, LocalDate end) {

        int totalDays = (int) ChronoUnit.DAYS.between(start, end);

        int weekDays = totalDays; // UC2 assumption
        int weekEnds = 0;

        Hotel cheapest = null;
        int minCost = Integer.MAX_VALUE;

        for (Hotel hotel : hotels) {

            int cost = hotel.calculateTotalCost(weekDays, weekEnds);

            if (cost < minCost) {
                minCost = cost;
                cheapest = hotel;
            }
        }

        return cheapest;
    }
}
