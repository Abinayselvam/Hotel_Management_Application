package Test;

import Enums.CustomerType;
import Exceptions.InvalidHotelException;
import Services.HotelReservationSystem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Entities.Hotel;
public class HotelReservationTest {

    // UC1 + UC3
    @Test
    void givenHotelRates_ShouldStoreRates() {

        Hotel hotel = new Hotel(
                "Lakewood",
                110,
                90,
                80,
                80,
                3
        );

        assertEquals(
                "Lakewood",
                hotel.name
        );

        assertEquals(
                110,
                hotel.regularWeekdayRate
        );

        assertEquals(
                90,
                hotel.regularWeekendRate
        );
    }


    // UC2


    @Test
    void givenHotel_shouldStoreRateAndRating()
    {
        Hotel hotel =
                new Hotel("Lakewood", 110, 90, 110,40,3);

        assertEquals(110, hotel.regularWeekdayRate);
        assertEquals(90, hotel.regularWeekendRate);
        assertEquals(3, hotel.rating);

    }
    @Test
    void givenMultipleHotels_ShouldReturnCheapestBestRatedHotel() throws InvalidHotelException {

        List<Hotel> hotels = List.of(
                new Hotel("Lakewood", 110, 90, 80,80,3),
                new Hotel("Bridge wood", 150, 50,110,40, 4),
                new Hotel("Ridgewood", 220, 150, 100,40,5)
        );

        HotelReservationSystem system = new HotelReservationSystem();

        Hotel result = system.findBestRatedCheapestHotel(
                hotels,
                CustomerType.Regular_Cus,
                2, // weekdays
                0  // weekends
        );

        assertEquals("Lakewood", result.name);
    }
}