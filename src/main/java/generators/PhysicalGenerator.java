package generators;

import person.models.Physical;

public interface PhysicalGenerator {
    int MIN_AGE = 10;
    int MIN_HEIGHT = 100;
    int MOD = 10;
    int MIN_WEIGHT = 30;
    double METER = 100.00;

    static Physical generate(int code) {
        final int coefficient = code % 1000 / 100;
        int age = (coefficient + 1) * MIN_AGE;
        int weight = MIN_WEIGHT + coefficient * MOD;
        double height = (MIN_HEIGHT + coefficient * MOD) / METER;
        return new Physical(age, weight, height);
    }
}
