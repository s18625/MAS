package MP1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Coach extends Person {
    private Integer yearOfGraduationPJATK; //nullable
    private List<Subject> knownSubjects;
    private double hoursOfTeaching = 0;
    static int minimalYearOfBirth = 1980;
    private List<PrivateLesson> privateLessonList = new ArrayList<>();


    public Coach(String name, String surname, LocalDate dateOfBirth, Integer yearOfGraduationPJATK, List<Subject> knownSubjects, double hourPayment) {
        super(name, surname, dateOfBirth);
        if (dateOfBirth.getYear() < minimalYearOfBirth) throw new ToOldException("u are too old to be our coach");
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
        this.knownSubjects = knownSubjects;
    }

    public Integer getYearOfGraduationPJATK() {
        return yearOfGraduationPJATK;
    }

    public void setYearOfGraduationPJATK(Integer yearOfGraduationPJATK) {
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
    }

    public List<Subject> getKnownSubjects() {
        return knownSubjects;
    }

    public void setKnownSubjects(List<Subject> knownSubjects) {
        this.knownSubjects = knownSubjects;
    }


    public double getHoursOfTeaching() {
        return hoursOfTeaching;
    }

    public void givePrivateLesson() {
        hoursOfTeaching += 1.5;
    }

    public void givePrivateLesson(double howManyHours) {
        hoursOfTeaching += howManyHours;
    }

    public static int getMinimalYearOfBirth() {
        return minimalYearOfBirth;
    }

    public static void setMinimalYearOfBirth(int minimalYearOfBirth) {
        Coach.minimalYearOfBirth = minimalYearOfBirth;
    }

    public String checkIfIsNull(Integer yearOfGraduationPJATK) {
        String result;
        Optional<Integer> optionalYearOfG = Optional.ofNullable(yearOfGraduationPJATK);
        result = optionalYearOfG.isPresent() ? String.valueOf(optionalYearOfG.get()) : "unknown";
        return result;
    }


    @Override
    public String toString() {
        return "Coach{" + super.toString() +
                ", knownSubjects=" + knownSubjects +
                ", yearOfGraduationPJATK = " + checkIfIsNull(yearOfGraduationPJATK) +
                ", hoursOfTeaching=" + hoursOfTeaching +
                '}';
    }
}
