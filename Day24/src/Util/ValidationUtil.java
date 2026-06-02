package Util;

import Exceptions.HotelReservationException;

public class ValidationUtil {

    public static void validateCustomerType(

            String type)

            throws HotelReservationException {

        if(!type.matches(

                "Regular|Reward"
        )) {

            throw new HotelReservationException(

                    "Invalid Customer Type"
            );
        }
    }
}