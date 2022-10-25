package generators;

import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;

public interface AppearanceGenerator {
    static Appearance generate(int code) {
        final int hairLength = code % 100 / 10;
        String eyesColor = EyesColor.values()[hairLength / 2].name().toLowerCase();
        String hairColor = null;
        if (hairLength > 0) {
            hairColor = HairColor.values()[hairLength - 1].name().toLowerCase();
        }
        return new Appearance(eyesColor, new Hair(hairLength, hairColor));
    }
}
