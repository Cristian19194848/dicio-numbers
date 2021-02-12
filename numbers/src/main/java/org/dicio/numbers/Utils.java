package org.dicio.numbers;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    public static final double WHOLE_NUMBER_ACCURACY = 0.0001f;
    public static final double WHOLE_FRACTION_ACCURACY = 0.0001f;

    private Utils() {
    }


    /**
     * @param number the number to check
     * @param accuracy the maximum distance to consider valid between the number and its nearest
     *                 whole number
     * @return whether the provided number is a whole number or a really near one (i.e. within the
     *         provided accuracy).
     */
    public static boolean isWhole(final double number, final double accuracy) {
        return Math.abs(number - Math.round(number)) < accuracy;
    }

    /**
     * Counts the useful decimal places that need to be considered. Formatting the number with the
     * returned count will not yield any zeros at the end.
     * @param number the number to count places of
     * @param maxPlaces the maximum number of places to return
     * @return the count of useful decimal places to be considered
     */
    public static int decimalPlacesNoFinalZeros(final double number, final int maxPlaces) {
        final String formatted = String.format("%." + maxPlaces + "f", Math.abs(number) % 1);

        int realPlaces = maxPlaces;
        while (realPlaces > 0 && formatted.charAt(realPlaces + 1) == '0') {
            --realPlaces;
        }

        return realPlaces;
    }

    /**
     * @param n the base
     * @param exponent the exponent
     * @return n ^ exponent
     */
    public static long longPow(final long n, final int exponent) {
        long result = 1;
        for (int e = 0; e < exponent; ++e) {
            result *= n;
        }
        return result;
    }

    /**
     * @param number the number to round
     * @return the nearest long to the number
     */
    public static long roundToLong(final double number) {
        if (number < 0) {
            return (long) number + (number % 1 <= -0.5 ? -1 : 0);
        } else {
            return (long) number + (number % 1 >= 0.5 ? 1 : 0);
        }
    }

    /**
     * @param n the number to split
     * @param splitModulus the modulus to apply to split the number
     * @return the splits (which could be 0), in opposite order,
     *         e.g. {@code splitByModulus(10294000, 1000) -> [0, 294, 10]}
     */
    public static List<Long> splitByModulus(long n, final int splitModulus) {
        final List<Long> result = new ArrayList<>();
        while (n > 0) {
            result.add(n % splitModulus);
            n /= splitModulus;
        }
        return result;
    }
}
