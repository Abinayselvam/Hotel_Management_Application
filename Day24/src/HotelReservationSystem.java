import java.util.ArrayList;

public class HotelReservationSystem {
    ArrayList<Hotel> hotels=new ArrayList<>();
    public void addHotel(Hotel hotel)
    {
        hotels.add(hotel);
        System.out.println("Hotel Added Successfully");
    }
    public void displayHotel()
    {
        System.out.println("Available Hotels");
        for (Hotel h:hotels)
        {
            System.out.println("Hotel Name: "+h.getName()+" | "+" Rate: "+h.getRate());
        }
    }
    public Hotel findCheapestHotel(
            int days) {

        Hotel cheapest =
                null;

        int minCost =
                Integer.MAX_VALUE;

        for(Hotel hotel : hotels) {

            int totalRate =
                    hotel.calculateRate(
                            days
                    );

            if(totalRate < minCost) {

                minCost =
                        totalRate;

                cheapest =
                        hotel;
            }
        }

        return cheapest;
    }
}
