import Enums.CustomerType;
import Entities.Hotel;
import Services.HotelReservationSystem;
import Util.DateUtil;
import Util.ValidationUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)

            throws Exception {

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

                "Input Format: "

                        +

                        "Reward:11Sep2020,12Sep2020"
        );

        String input =
                scanner.nextLine();

        String[] parts =
                input.split(":");

        String type =
                parts[0].trim();

        ValidationUtil
                .validateCustomerType(
                        type
                );

        CustomerType customerType =

                type.equalsIgnoreCase(
                        "Reward"
                )

                        ?

                        CustomerType
                        .Reward_Cus

                        :

                        CustomerType
                        .Regular_Cus;

        String[] dates =

                parts[1]
                        .split(",");

        DateTimeFormatter formatter =

                DateTimeFormatter
                        .ofPattern(
                                "ddMMMyyyy"
                        );

        LocalDate startDate =

                LocalDate.parse(

                        dates[0].trim(),

                        formatter
                );

        LocalDate endDate =

                LocalDate.parse(

                        dates[1].trim(),

                        formatter
                );

        int[] counts =

                DateUtil
                        .getWeekdayWeekendCount(

                                startDate,

                                endDate
                        );

        Hotel cheapest =

                system
                        .findBestRatedCheapestHotel(

                                system.hotels,

                                customerType,

                                counts[0],

                                counts[1]
                        );

        int totalCost =

                cheapest
                        .calculateTotalRate(

                                customerType,

                                counts[0],

                                counts[1]
                        );

        System.out.println(

                cheapest.name

                        +

                        " Rating: "

                        +

                        cheapest.rating

                        +

                        " Total Cost:$"

                        +

                        totalCost
        );
    }
}