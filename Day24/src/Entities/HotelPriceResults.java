package Entities;

public class HotelPriceResults{

    public Hotel hotel;

    public int totalCost;

    public HotelPriceResults(

            Hotel hotel,

            int totalCost) {

        this.hotel =
                hotel;

        this.totalCost =
                totalCost;
    }
}