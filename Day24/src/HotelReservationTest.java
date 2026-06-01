import org.junit.jupiter.api.Test;

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

        HotelReservationSystem reservation =
                new HotelReservationSystem();

        reservation.addHotel(new Hotel("Lakewood",
                110,
                90)

        );

        reservation.addHotel(new Hotel("Bridgewood",
                150,
                50)

        );

        reservation.addHotel(new Hotel("Ridgewood",
                220,
                150)

        );

        Hotel cheapestHotel =
                reservation.findCheapestHotel(
                        2
                );

        assertEquals(
                "Lakewood",
                cheapestHotel.name
        );
    }
}