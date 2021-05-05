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
    public Person(String name, String surname, LocalDate dateOfBirth, String indexNumber) {
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        addStudent(indexNumber);
    }
    public Person(String name, String surname, LocalDate dateOfBirth, Integer yearOfGraduationPJATK, double hourPayment) {
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        addCoach(yearOfGraduationPJATK,hourPayment);
    }

    public void addStudent(String indexNumber){
        Student student = new Student(name,surname,dateOfBirth,indexNumber);
        this.addLink(Roles.STUDENT,Roles.PERSON,student);
    }

    public void addCoach(Integer yearOfGraduationPJATK, double hourPayment){
        Coach coach = new Coach(name,surname,dateOfBirth,yearOfGraduationPJATK,hourPayment);
        this.addLink(Roles.COACH,Roles.PERSON,coach);
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

    abstract Person getOtherParticipantPrivateLesson(PrivateLesson privateLesson) throws Exception;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth;
    }
}
