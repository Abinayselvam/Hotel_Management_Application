package Services;

import Entities.HotelPriceResults;
import Enums.CustomerType;
import Entities.Hotel;
import Exceptions.InvalidHotelException;

import java.util.*;


public class HotelReservationSystem {
    public ArrayList<Hotel> hotels=new ArrayList<>();
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

            CustomerType type,

            int weekdayCount,

            int weekendCount)

            throws InvalidHotelException {

        if(hotels.isEmpty()) {

            throw new InvalidHotelException(
                    "No Hotels Available"
            );
        }

        return hotels.stream()

                .map(

                        hotel ->

                                new HotelPriceResults(

                                        hotel,

                                        hotel.calculateTotalRate(

                                                type,

                                                weekdayCount,

                                                weekendCount
                                        )
                                )
                )

                .sorted((h1,h2)->{

                    if(h1.totalCost!=h2.totalCost) {

                        return Integer.compare(
                                h1.totalCost,
                                h2.totalCost
                        );
                    }

                    return Integer.compare(
                            h2.hotel.rating,
                            h1.hotel.rating
                    );
                })

                .map(result -> result.hotel)

                .findFirst()

                .orElseThrow(

                        () -> new InvalidHotelException(
                                "Unable to Find Hotel"
                        )
                );
    }

}
