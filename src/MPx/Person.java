package MPx;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person extends ObjectPlusPlus {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;


    public Person(String name, String surname, LocalDate dateOfBirth) {
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return countAge(this.dateOfBirth);
    }

    private static int countAge(LocalDate dateOfBirth) {
        int yearOfBirth = dateOfBirth.getYear();
        return Period.between(LocalDate.ofEpochDay(yearOfBirth), dateOfBirth).getYears();
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth;
    }
}
