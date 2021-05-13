package MPx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject extends ObjectPlusPlus implements Serializable {
    private String acronym;
    private String fullName;
    private final List<Coach> coachesOfSubject = new ArrayList<>();
    private final Set<String> setOfAcronyms = new HashSet<>();

    public Subject(String acronym, String fullName) throws Exception {
        setAcronym(acronym);
        this.fullName = fullName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) throws Exception {
        if (setOfAcronyms.contains(acronym)) throw  new Exception("this subject already exist");
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
