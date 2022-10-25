package generators;

import person.models.Fio;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public interface FioGenerator {
    static Fio generate(int code) {
        final int digitsSum = getDigitsSum(code);
        final String fioName = (digitsSum % 2 == 0) ? "f" : "m";
        return new Fio(
                getLinesFromFile("lastNames_" + fioName).get(digitsSum),
                getLinesFromFile("names_" + fioName).get(getDigitsSum(code / 100)),
                getLinesFromFile("middleNames_" + fioName).get(getDigitsSum(code % 100))
        );
    }
}
