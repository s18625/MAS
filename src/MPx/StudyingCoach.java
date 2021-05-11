package MPx;

import java.time.LocalDate;

public class StudyingCoach extends Coach implements IStudent {
    Student student;

    public StudyingCoach(String name, String surname, LocalDate dateOfBirth, Integer yearOfGraduationPJATK, double hourPayment, String indexNumber) throws Exception {
        super(name, surname, dateOfBirth, yearOfGraduationPJATK, hourPayment);
        student = new Student(null, null, null, indexNumber);
    }

    @Override
    public String getIndexNumber() {
        return student.getIndexNumber();
    }

    @Override
    public void rateTheCoach(Coach coach, double rating) throws Exception {
        if (rating<0 || rating>10) throw  new Exception("rating should be between 0-10");
        coach.setRating(rating);
    }

    @Override
    public String toString() {
        return "StudyingCoach{" +
                "name=" + this.getName() +
                " surname=" + this.getSurname() +
                " dateOfBirth=" + this.getDateOfBirth() +
                " yearOfGraduationPJATK=" + this.getYearOfGraduationPJATK() +
                " hourPayment=" + this.getHourPayment() +
                " indexNumber=" + student.getIndexNumber() +
                '}';
    }
}
