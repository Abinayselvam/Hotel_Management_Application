public class Hotel {
    String name;
    int regularRate;
    int regularWeekdayRate;
    int regularWeekendRate;
    int rewardWeekdayRate;
    int rewardWeekendRate;
    public Hotel(String name,int regularRate)
    {
        this.name=name;
        this.regularRate=regularRate;
    }
    public String getName()
    {
        return name;
    }
    public int getRate() {
        return regularRate;
    }
    public int calculateRate(
            int days) {

        return regularRate * days;
    }
}
