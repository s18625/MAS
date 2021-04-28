package MPx;

import java.time.LocalDate;
import java.util.Comparator;

public class Student extends Person {
    private String indexNumber;
//    private final List<Advertisement> advertisements = new ArrayList<>();
//    private final List<PrivateLesson> privateLessonList = new ArrayList<>();

    public Student(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String indexNumber) {
        super(name, surname, dateOfBirth);
        this.indexNumber = indexNumber;
    }


    public String getIndexNumber() {
        return indexNumber;
    }


    public static Student  findTheOldestStudent() throws ClassNotFoundException {
        var students = ObjectPlus.getExtentOfClass(Student.class);
        return ObjectPlus.getExtentOfClass(Student.class).stream().max(Comparator.comparing(Student::getAge)).get();

    }


    //===  MP2  ========================================================================================================

//    public void addAdvertisement(Advertisement newAdvertisement) {
//        if (!advertisements.contains(newAdvertisement)) {
//            newAdvertisement.setStudentsAuthor(this);
//            advertisements.add(newAdvertisement);
//        }
//    }
//
//    public void addPrivateLesson(PrivateLesson newPrivateLesson) {
//        if (!privateLessonList.contains(newPrivateLesson)) {
//            privateLessonList.add(newPrivateLesson);
//        }
//    }


    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", indexNumber='" + indexNumber + '\'' +
//                ", advertisements=" + advertisements +
                '}';
    }
}
