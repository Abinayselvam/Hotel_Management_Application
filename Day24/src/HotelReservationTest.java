import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {

    // UC1 + UC3
    @Test
    void givenHotelRates_ShouldStoreRates() {

        Hotel hotel = new Hotel(
                "Lakewood",
                110,
                90
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

        system.addHotel(new Hotel("Lakewood", 110, 90));
        system.addHotel(new Hotel("Bridgewood", 150, 50));
        system.addHotel(new Hotel("Ridgewood", 220, 150));

        LocalDate start = LocalDate.of(2020, 9, 10);
        LocalDate end = LocalDate.of(2020, 9, 11);

        Hotel cheapest = system.findCheapestHotel(start, end);

        assertEquals("Lakewood", cheapest.name);
    }
}