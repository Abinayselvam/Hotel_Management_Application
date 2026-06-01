import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation System");

        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood",110,90,3));
        system.addHotel(new Hotel("Bridgewood",150,60,4));
        system.addHotel(new Hotel("Ridgewood",220,150,5));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dates (10Sep2020,11Sep2020)");

        String input = scanner.nextLine();
        String[] dates = input.split(",");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("ddMMMyyyy");

        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        Hotel cheapest =
                system.findCheapestHotel(startDate, endDate);

        int totalDays =
                (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);

        int totalCost =
                cheapest.calculateTotalCost(totalDays, 0);

        System.out.println(
                cheapest.getName() + " $" + totalCost
        );

        scanner.close();
    }
}