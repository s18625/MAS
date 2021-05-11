package MPx;


import java.time.LocalDate;
import java.util.*;


public class Coach extends Person {
    private Integer yearOfGraduationPJATK; //nullable
    private double hoursOfTeaching = 0;
    static int minimalYearOfBirth = 1980;
    double hourPayment;
    private double rating;
    private int totalRaters;
    private static double maximalHourPayment =200.0;

    public Coach(String name, String surname, LocalDate dateOfBirth, Integer yearOfGraduationPJATK, double hourPayment) throws Exception {
        super(name, surname, dateOfBirth);
        if (dateOfBirth != null && dateOfBirth.getYear() < minimalYearOfBirth)
            throw new ToOldException("u are too old to be our coach");
        setHourPayment(hourPayment);
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
    }

    public Coach(Person person, Integer yearOfGraduationPJATK, double hourPayment) {
        super(person.getName(), person.getSurname(), person.getDateOfBirth());
        this.hourPayment = hourPayment;
        if (person.getDateOfBirth() != null && person.getDateOfBirth().getYear() < minimalYearOfBirth)
            throw new ToOldException("u are too old to be our coach");
        this.yearOfGraduationPJATK = yearOfGraduationPJATK;
    }

    public static void setMaximalHourPayment(double maximalHourPayment) {
        Coach.maximalHourPayment = maximalHourPayment;
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

    public double getHourPayment() {
        return hourPayment;
    }

    public void setHourPayment(double hourPayment) throws Exception {
        if (hourPayment > 200.0){
            throw  new Exception(String.format("your hour payment - %.2fzł is to high by %.2fzł, maximal hour payment is %.2fzł",hourPayment,hourPayment-maximalHourPayment,maximalHourPayment));
        };
        this.hourPayment = hourPayment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.totalRaters++;
        this.rating = (this.rating+rating)/totalRaters;
    }

    public int getTotalRaters() {
        return totalRaters;
    }


    public String checkIfIsNull(Integer yearOfGraduationPJATK) {
        String result;
        Optional<Integer> optionalYearOfG = Optional.ofNullable(yearOfGraduationPJATK);
        result = optionalYearOfG.isPresent() ? String.valueOf(optionalYearOfG.get()) : "unknown";
        return result;
    }

    @Override
    Person getOtherParticipantPrivateLesson(PrivateLesson privateLesson) throws Exception {
        if (privateLesson.getCoach() != this) throw new Exception("this coach wasnt participant");
        return privateLesson.getStudent();
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
                ", averageRatingFromTheStudents=" + rating +
                '}';
    }
}
