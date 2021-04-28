package MPx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject extends ObjectPlusPlus implements Serializable {
    private String acronym;
    private String fullName;
    private final List<Coach> coachesOfSubject = new ArrayList<>();

    public Subject(String acronym, String fullName) {
        this.acronym = acronym;
        this.fullName = fullName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addCoach(Coach newCoach) {
        if (!coachesOfSubject.contains(newCoach)) {
            coachesOfSubject.add(newCoach);
        }
    }


    @Override
    public String toString() {
        return "Subject {" +
                "acronym ='" + acronym + '\'' +
                ", fullName ='" + fullName + '\'' +
                '}';
    }
}
