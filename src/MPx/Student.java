package MPx;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person implements IStudent {
    private static final Set<String> allIndexNumbers = new HashSet<>() {
    };
    private String indexNumber;
    private int maxHobbyNumber = 3;

    public Student(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String indexNumber) throws Exception {
        super(name, surname, dateOfBirth);
        setIndexNumber(indexNumber);
    }

    @Override
    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) throws Exception {
        if (this.containTheRole(roleName) && roleName.equals(Roles.HOBBY) && this.getLinks(Roles.HOBBY).length>=maxHobbyNumber) throw  new Exception("too many hobbies");
        super.addLink(roleName, reverseRoleName, targetObject, targetObject);
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

    public int getMaxHobbyNumber() {
        return maxHobbyNumber;
    }

    public void setMaxHobbyNumber(int maxHobbyNumber) {
        this.maxHobbyNumber = maxHobbyNumber;
    }

    private void setIndexNumber(String indexNumber) throws Exception {
        if (allIndexNumbers.contains(indexNumber)) throw new Exception(String.format("Student with this index number %s already exist",indexNumber));
        allIndexNumbers.add(indexNumber);
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
