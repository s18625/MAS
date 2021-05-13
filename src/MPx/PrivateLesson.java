package MPx;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;

public class PrivateLesson extends ObjectPlusPlus implements Serializable {
    private Integer grade;
    private Double prizePerHour;
    private Double time;
    private LocalDate date;
    private final Coach coach;
    private final Student student;
    private final Subject subject;

    public PrivateLesson(Integer grade, Double prizePerHour, Double time, LocalDate date, Coach coach, Student student, URL linkToLecture, String linkToRepository,Subject subject) throws Exception {
        super();
        this.grade = grade;
        this.prizePerHour = prizePerHour;
        this.time = time;
        this.date = date;
        this.coach = coach;
        this.student = student;
        this.subject = subject;

        this.addLink(Roles.STUDENT, Roles.PRIVATE_LESSON, student);
        this.addLink(Roles.COACH, Roles.PRIVATE_LESSON, coach);

        addTheoreticalPrivateLesson(linkToLecture);
        addPracticalPrivateLesson(linkToRepository);

    }

    private void addTheoreticalPrivateLesson(URL linkToLecture) throws Exception {
        if (linkToLecture == null) return;
        TheoreticalPrivateLesson theoreticalPrivateLesson = new TheoreticalPrivateLesson(linkToLecture);
        this.addLink(Roles.TYPE_NAME_THEORETICAL, Roles.PRIVATE_LESSON, theoreticalPrivateLesson);
    }

    private void addPracticalPrivateLesson(String linkToRepository) throws Exception {
        if (linkToRepository == null) return;
        PracticalPrivateLesson practicalPrivateLesson = new PracticalPrivateLesson(linkToRepository);
        this.addLink(Roles.TYPE_NAME_PRACTICAL, Roles.PRIVATE_LESSON, practicalPrivateLesson);
    }

    public Subject getSubject() {
        return subject;
    }


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

    public Coach getCoach() {
        return coach;
    }

    public Student getStudent() {
        return student;
    }


    private TheoreticalPrivateLesson getTheoreticalPrivateLesson() throws NotATheoreticalLessonException {
        try {
            return (TheoreticalPrivateLesson) this.getLinks(Roles.TYPE_NAME_THEORETICAL)[0];
        } catch (Exception e) {
            throw new NotATheoreticalLessonException("this object is not TheoreticalPrivateLesson Object");
        }
    }
    public URL getLinkToLecture() throws Exception {
        return getTheoreticalPrivateLesson().getLinkToLecture();
    }

    public void setLinkToLecture(URL linkToLecture) throws Exception {
        getTheoreticalPrivateLesson().setLinkToLecture(linkToLecture);
    }


    private PracticalPrivateLesson getPracticalPrivateLesson() throws NotAPracticalLessonException {
        try {
            return (PracticalPrivateLesson) this.getLinks(Roles.TYPE_NAME_PRACTICAL)[0];
        } catch (Exception e) {
            throw new NotAPracticalLessonException("this object is not PracticalPrivateLesson Object");
        }
    }
    public String getLinkToRepository() throws NotAPracticalLessonException {
        return getPracticalPrivateLesson().getLinkToRepository();
    }

    public void setLinkToRepository(String linkToRepository) throws NotAPracticalLessonException {
        getPracticalPrivateLesson().setLinkToRepository(linkToRepository);
    }

    private OnlinePrivateLesson getOnlinePrivateLesson() throws Exception {
        try {
            return (OnlinePrivateLesson) this.getLinks(Roles.PART)[0];
        } catch (Exception e) {
            throw new Exception("this object is not OnlinePrivateLesson Object");
        }
    }
    public String getPlatformName() throws Exception {
        return getOnlinePrivateLesson().getPlatformName();
    }

    public void setPlatformName(String platformName) throws Exception {
        getOnlinePrivateLesson().setPlatformName(platformName);
    }
    private StationaryPrivateLesson getStationaryPrivateLesson() throws Exception {
        try {
            return (StationaryPrivateLesson) this.getLinks(Roles.PART)[0];
        } catch (Exception e) {
            throw new Exception("this object is not StationaryPrivateLesson Object");
        }
    }

    public String getAddress() throws Exception {
        return getStationaryPrivateLesson().getAddress();
    }

    public void setAddress(String address) throws Exception {
        getStationaryPrivateLesson().setAddress(address);
    }


    public String getPartIfNotNull(String RoleName) throws Exception {
        return this.containTheRole(RoleName) ? String.valueOf(" "+this.getLinks(RoleName)[0]) : "";
    }

    @Override
    public String toString() {
        String theoreticalAndPractical = null;
        String mode = null;
        try {
            theoreticalAndPractical = getPartIfNotNull(Roles.TYPE_NAME_THEORETICAL) + getPartIfNotNull(Roles.TYPE_NAME_PRACTICAL);
            mode = getPartIfNotNull(Roles.PART);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "PrivateLesson{" +
                "grade=" + grade +
                ", prizePerHour=" + prizePerHour +
                ", time=" + time +
                ", date=" + date +
                ", coach=" + coach.getSurname() +
                ", student=" + student.getSurname() +
                theoreticalAndPractical +
                mode +
                '}';
    }
}
