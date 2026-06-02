package Util;

import Exceptions.HotelReservationException;
import Exceptions.InvalidHotelException;

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
    static String DATE_REGEX =

            "^\\d{2}[A-Z][a-z]{2}\\d{4}$";

    public static void validateDate(

            String date)

            throws InvalidHotelException {

        if(!date.matches(DATE_REGEX)) {

            throw new InvalidHotelException(

                    "Invalid Date Format"
            );
        }
    }
}