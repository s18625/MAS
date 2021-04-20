package MP1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class Student extends Person {
    private String indexNumber;
    private final List<Advertisement> advertisements = new ArrayList<>();
    private List<PrivateLesson> privateLessonList = new ArrayList<>();

    public Student(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String indexNumber) {
        super(name, surname, dateOfBirth);
        this.indexNumber = indexNumber;
    }

    public void addAdvertisement(Advertisement newAdvertisement){
        if (!advertisements.contains(newAdvertisement)){
            newAdvertisement.setStudentsAuthor(this);
            advertisements.add(newAdvertisement);
        }
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public static void showAllAvailableSubjects() {
        Arrays.stream(Subject.values()).forEach(subject -> {
            out.printf("%s - %s \n", subject, subject.getFullName());
        });
    }

    public static Student findTheOldestStudent() throws ClassNotFoundException {
        var oldestStudent = ObjectPlus.getExtentOfClass(Student.class).stream().max(Comparator.comparing(Student::getAge)).get();
        return oldestStudent;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", indexNumber='" + indexNumber + '\'' +
                ", advertisements="+ advertisements +
                '}';
    }
}
