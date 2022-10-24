package person;

import generators.ParamGenerator;
import person.models.Phone;
import utils.MyMath;

import java.util.Random;

public class PersonFactory {

    public static Person getPerson(final String code) {
        Person.Builder person = new Person.Builder(code);
        final int intCode = Integer.parseInt(code);
        person.withLastName(new ParamGenerator().lngeneration(intCode));
        person.withFirstName(new ParamGenerator().fngeneration(intCode));
        person.withMiddleName(new ParamGenerator().mngeneration(intCode));
        person.withPhysical(new ParamGenerator().GenPh(intCode));
        //person.withSnils(new ParamGenerator().generateSnils(intCode))
        person.withAppearance(new ParamGenerator().gen_Ap(intCode));
        // добавляем телефон, только если введённый код не палиндром
        if (!code.equals(new StringBuilder(code).reverse().toString())) {
            final String number = "+79"
                    + String.format("%02d", MyMath.getDigitsSum(intCode))
                    + String.format("%03d", new Random().nextInt(1000))
                    + String.format("%04d", intCode);
            final Phone phone = new Phone(number);
            person.withPhone(phone);
        }
        return person.build();
    }
}
