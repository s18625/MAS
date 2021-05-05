package MPx;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Student extends Person implements IStudent {
    private String indexNumber;

    public Student(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String indexNumber) {
        super(name, surname, dateOfBirth);
        this.indexNumber = indexNumber;
    }

    @Override
    Person getOtherParticipantPrivateLesson(PrivateLesson privateLesson) throws Exception {
        if (privateLesson.getStudent() != this) throw new Exception("this student ia not participant");
        return privateLesson.getCoach();
    }

    public Student(Person person, String indexNumber) {
        super(person.getName(), person.getSurname(), person.getDateOfBirth());
        this.indexNumber = indexNumber;
    }


    @Override
    public String getIndexNumber() {
        return indexNumber;
    }

    @Override
    public void rateTheCoach(Coach coach, double rating) throws Exception {
        if (rating<0 || rating>10) throw  new Exception("ratign should be between 0-10");
        coach.setRating(rating);
    }

    static Student findTheOldestStudent() throws ClassNotFoundException {
        var students = ObjectPlus.getExtentOfClass(Student.class);
        return ObjectPlus.getExtentOfClass(Student.class).stream().filter(student -> student.getDateOfBirth() != null).max(Comparator.comparing(Student::getAge)).get();

    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", indexNumber='" + indexNumber + '\'' +
                '}';
    }
}
