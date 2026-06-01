public class Hotel {
    String name;
    int regularWeekdayRate;
    int regularWeekendRate;
    int rewardWeekdayRate;
    int rewardWeekendRate;
    int ratings;
    public Hotel(String name,int regularWeekdayRate,int regularWeekendRate,int ratings)
    {
        this.name=name;
        this.regularWeekdayRate=regularWeekdayRate;
        this.regularWeekendRate=regularWeekendRate;
        this.ratings=ratings;
    }
    public int getRatings()
    {
        return ratings;
    }
    public String getName()
    {
        return name;
    }
    public int calculateTotalCost(
            int weekDays,int weekEnds) {

        return  (weekDays*regularWeekdayRate)+(weekEnds*regularWeekendRate);
    }
}
