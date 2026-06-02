package Entities;
import Enums.CustomerType;

import java.security.PublicKey;

public class Hotel {

    public String  name;

   public int regularWeekdayRate;
   public int regularWeekendRate;

   public int rewardWeekdayRate;
   public int rewardWeekendRate;

   public int rating;

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

            CustomerType type,

            int weekdayCount,

            int weekendCount) {

        if(type == CustomerType.Regular_Cus) {

            return

                    (weekdayCount * regularWeekdayRate)

                            +

                            (weekendCount * regularWeekendRate);
        }

        return

                (weekdayCount * rewardWeekdayRate)

                        +

                        (weekendCount * rewardWeekendRate);
    }
}