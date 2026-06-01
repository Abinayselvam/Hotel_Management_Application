import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Online Hotel Reservation Management");
        HotelReservationSystem system =
                new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood",110,90));
        system.addHotel(new Hotel("Bridgewood",150,60));
        system.addHotel(new Hotel("Ridgewood",220,150));

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Enter dates (Example: 10Sep2020,11Sep2020)"
        );

        String input = scanner.nextLine();

        String[] dates = input.split(",");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("ddMMMyyyy");

        LocalDate startDate =
                LocalDate.parse(dates[0],formatter);

        LocalDate endDate =
                LocalDate.parse(dates[1],formatter);

        int days = (int)
                ChronoUnit.DAYS.between(
                        startDate,
                        endDate
                );

        Hotel cheapest =
                system.findCheapestHotel(days);

        int totalCost =
                cheapest.getRate() * days;

        System.out.println(

                cheapest.name +

                        ", Total Rates: $" +

                        cheapest.calculateRate(
                                2
                        )+
                cheapest.getName() +
                        " $" + totalCost
        );


        scanner.close();

    }
}