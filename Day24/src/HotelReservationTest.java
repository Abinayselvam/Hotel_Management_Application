import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {

    // UC1 + UC3
    @Test
    void givenHotelRates_ShouldStoreRates() {

        Hotel hotel = new Hotel(
                "Lakewood",
                110,
                90,3
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
                new Hotel("Lakewood", 110, 90, 3);

        assertEquals(110, hotel.regularWeekdayRate);
        assertEquals(90, hotel.regularWeekendRate);
        assertEquals(3, hotel.ratings);

    }
    @Test
    void givenDateRange_ShouldReturnCheapestBestRatedHotel() {

        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 110, 90, 3));
        system.addHotel(new Hotel("Bridgewood", 150, 50, 4));
        system.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        Hotel result = system.findCheapestBestRated(1, 1);

        assertEquals("Bridgewood", result.name);
    }
}