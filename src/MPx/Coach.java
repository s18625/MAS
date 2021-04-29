package MPx;


import java.time.LocalDate;
import java.util.*;


public class Coach extends Person {
    private Integer yearOfGraduationPJATK; //nullable
    private double hoursOfTeaching = 0;
    static int minimalYearOfBirth = 1980;

    public Coach(String name, String surname, LocalDate dateOfBirth, Integer yearOfGraduationPJATK, double hourPayment) {
        super(name, surname, dateOfBirth);
        if (dateOfBirth.getYear() < minimalYearOfBirth) throw new ToOldException("u are too old to be our coach");
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
    }


    public Integer getYearOfGraduationPJATK() {
        return yearOfGraduationPJATK;
    }

    public void setYearOfGraduationPJATK(Integer yearOfGraduationPJATK) {
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
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


    public void showSubjectByAcronym(String acronym) throws Exception {
        ObjectPlusPlus linkedObject = this.getLinkedObject(Roles.SUBJECT, acronym);
        System.out.println(linkedObject);
    }

    @Override
    public String toString() {
        return "Coach{" + super.toString() +
                ", yearOfGraduationPJATK = " + checkIfIsNull(yearOfGraduationPJATK) +
                ", hoursOfTeaching=" + hoursOfTeaching +
                '}';
    }
}
