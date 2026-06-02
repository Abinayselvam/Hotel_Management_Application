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

    public Hotel findBestRatedCheapestHotel(

            List<Hotel> hotels,
            CustomerType types,

            int weekdayCount,

            int weekendCount) {

        return hotels.stream()

                .map(

                        hotel ->

                                new HotelPriceResults(

                                        hotel,

                                        hotel.calculateTotalRate(

                                                CustomerType.Regular_Cus,

                                                2,

                                                1
                                        )
                                )
                )

                .sorted(

                        (h1, h2) -> {

                            if(h1.totalCost
                                    !=
                                    h2.totalCost) {

                                return Integer.compare(

                                        h1.totalCost,

                                        h2.totalCost
                                );
                            }

                            return Integer.compare(

                                    h2.hotel.rating,

                                    h1.hotel.rating
                            );
                        }
                )

                .map(

                        result -> result.hotel
                )

                .findFirst()

                .orElse(null);
    }}
