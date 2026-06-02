import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HotelReservationSystem system =
                new HotelReservationSystem();

        system.addHotel(
                new Hotel(
                        "Lakewood",
                        110,
                        90,
                        80,
                        80,
                        3
                )
        );

        system.addHotel(
                new Hotel(
                        "Bridgewood",
                        150,
                        60,
                        110,
                        50,
                        4
                )
        );

        system.addHotel(
                new Hotel(
                        "Ridgewood",
                        220,
                        150,
                        100,
                        40,
                        5
                )
        );

        Scanner scanner =
                new Scanner(System.in);

        System.out.println(
                "Enter start date:"
        );

        String startInput =
                scanner.nextLine();

        System.out.println(
                "Enter end date:"
        );

        String endInput =
                scanner.nextLine();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate startDate =
                LocalDate.parse(
                        startInput,
                        formatter
                );

        LocalDate endDate =
                LocalDate.parse(
                        endInput,
                        formatter
                );

        int[] counts =

                DateUtil
                        .getWeekdayWeekendCount(
                                startDate,
                                endDate
                        );

        int weekdayCount =
                counts[0];

        int weekendCount =
                counts[1];

        Hotel cheapest =

                system.findBestRatedCheapestHotel(

                        system.hotels,
                        CustomerType.Regular_Cus,

                        weekdayCount,

                        weekendCount
                );

        System.out.println(

                cheapest.name
        );
    }
}