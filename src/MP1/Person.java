package MP1;

import java.time.LocalDate;

public abstract class Person extends ObjectPlus {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;


    public Person(String name, String surname, LocalDate dateOfBirth) {
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

    private int countAge(LocalDate dateOfBirth) {
        int yearOfBirth = dateOfBirth.getYear();
        return LocalDate.now().getYear() - yearOfBirth;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth;
    }
}
