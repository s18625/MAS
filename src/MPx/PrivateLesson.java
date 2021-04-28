package MPx;

import java.io.Serializable;
import java.time.LocalDate;

public class PrivateLesson extends ObjectPlusPlus implements Serializable {
//    private Coach coach;
//    private Student student;
    private Integer grade;
    private Double prizePerHour;
    private Double time;
    private LocalDate date;
    private Coach coach;
    private Student student;

    public PrivateLesson( Integer grade, Double prizePerHour, Double time, LocalDate date,Coach coach, Student student) {
        super();
        this.grade = grade;
        this.prizePerHour = prizePerHour;
        this.time = time;
        this.date = date;
        this.coach = coach;
        this.student = student;

        this.addLink(Roles.STUDENT, Roles.PRIVATE_LESSON,student);
        this.addLink(Roles.COACH, Roles.PRIVATE_LESSON,coach);
    }

//    public Coach getCoach() {
//        return coach;
//    }
//
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getPrizePerHour() {
        return prizePerHour;
    }

    public void setPrizePerHour(Double prizePerHour) {
        this.prizePerHour = prizePerHour;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
