import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Online Hotel Reservation Management");
        Scanner scanner=new Scanner(System.in);
        HotelReservationSystem system=new HotelReservationSystem();
        System.out.println("Enter the hotel name: ");
        String name=scanner.nextLine();
        System.out.println("Enter the rate:");
        int rate=scanner.nextInt();
        Hotel hotel=new Hotel(name,rate);
        system.addHotel(hotel);
        system.displayHotel();
        scanner.close();

    }
}