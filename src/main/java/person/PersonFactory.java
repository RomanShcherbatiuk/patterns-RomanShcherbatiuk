package person;

import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhysicalGenerator;

public class PersonFactory implements AppearanceGenerator, FioGenerator, PhysicalGenerator {

    public static Person getPerson(final String code) {
        Person.Builder person = new Person.Builder(code);
        final int intCode = Integer.parseInt(code);
        person.withFio(FioGenerator.generate(intCode));
        person.withAppearance(AppearanceGenerator.generate(intCode));
        person.withPhysical(PhysicalGenerator.generate(intCode));
        return person.build();
    }
}
