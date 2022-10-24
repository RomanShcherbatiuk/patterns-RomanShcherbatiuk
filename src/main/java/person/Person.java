package person;

import person.models.Phone;
import person.models.Physical;
import person.models.appearance.Appearance;

import java.util.Objects;

public class Person {

    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(lastName).append(" ").append(firstName).append(" ").append(middleName).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n")
                .append(phone);
        return sb.toString();
    }

    public static final class Builder {

        private final String id;
        private String lastName;
        private String firstName;
        private String middleName;
        private Appearance appearance;
        private Physical phys;
        private Phone phone;

        public Builder(final String id) {
            this.id = id;
        }

        public void withLastName(final String newLastName) {
            lastName = newLastName;
        }

        public void withFirstName(final String newFirstName) {
            firstName = newFirstName;
        }

        public void withMiddleName(final String newMiddleName) {
            middleName = newMiddleName;
        }

        public void withPhysical(final Physical newPhys) {
            phys = newPhys;
        }

        public void withAppearance(final Appearance newAppearance) {
            appearance = newAppearance;
        }

        public void withPhone(final Phone newPhone) {
            phone = newPhone;
        }


        public Person build() {
            final Person person = new Person();
            person.id = this.id;
            person.phys = this.phys;
            person.lastName = this.lastName;
            person.firstName = this.firstName;
            person.middleName = this.middleName;
            person.appearance = this.appearance;
            person.phone = Objects.requireNonNullElseGet(this.phone, () -> new Phone("N/A"));
            return person;
        }
    }
}