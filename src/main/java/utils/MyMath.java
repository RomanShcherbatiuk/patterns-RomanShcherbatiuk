package utils;

public class MyMath {

    public static int getDigitsSum(final int src) {
        int sum = 0;
        for (String stringDigit : String.valueOf(src).split("")) {
            sum += Integer.parseInt(stringDigit);
        }
        return sum;
    }
}
