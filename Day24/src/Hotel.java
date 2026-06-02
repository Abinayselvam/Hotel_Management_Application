public class Hotel {

    String name;

    int regularWeekdayRate;
    int regularWeekendRate;

    int rewardWeekdayRate;
    int rewardWeekendRate;

    int rating;

    public String getName()
    {
        return name;
    }
    public Hotel(

            String name,

            int regularWeekdayRate,

            int regularWeekendRate,
            int rewardWeekendRate,
            int rewardWeekdayRate,
            int rating) {

        this.name = name;

        this.regularWeekdayRate =
                regularWeekdayRate;

        this.regularWeekendRate =
                regularWeekendRate;
        this.rewardWeekendRate=rewardWeekendRate;
        this.rewardWeekdayRate=rewardWeekdayRate;

        this.rating =
                rating;
    }

    public int calculateTotalRate(

            CustomerType customerType,

            int weekdayCount,

            int weekendCount) {

        if(customerType
                ==
                CustomerType.Regular_Cus) {

            return

                    (weekdayCount
                            * regularWeekdayRate)

                            +

                            (weekendCount
                                    * regularWeekendRate);
        }

        else {

            return

                    (weekdayCount
                            * rewardWeekdayRate)

                            +

                            (weekendCount
                                    * rewardWeekendRate);
        }
    }
}