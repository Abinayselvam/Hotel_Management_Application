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
    void givenDateRange_ShouldReturnCheapestHotel() {

        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 110, 90,3));
        system.addHotel(new Hotel("Bridgewood", 150, 50,4));
        system.addHotel(new Hotel("Ridgewood", 220, 150,5));

        LocalDate start = LocalDate.of(2020, 9, 10);
        LocalDate end = LocalDate.of(2020, 9, 11);

        Hotel cheapest = system.findCheapestHotel(start, end);

        assertEquals("Lakewood", cheapest.name);
    }
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
    void givenDateRange_shouldReturnCheapestBestRatedHotel() {

        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 110, 90, 3));
        system.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        system.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        Hotel result = system.findCheapestHotel(dates);

        assertEquals("Bridgewood", result.name);
    }
}