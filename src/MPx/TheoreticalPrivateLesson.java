package MPx;

import java.net.URL;
import java.time.LocalDate;

public class TheoreticalPrivateLesson extends ObjectPlusPlus{
    private URL linkToLecture;
    public TheoreticalPrivateLesson(URL linkToLecture) {
        this.linkToLecture = linkToLecture;
    }

    public URL getLinkToLecture() {
        return linkToLecture;
    }

    public void setLinkToLecture(URL linkToLecture) {
        this.linkToLecture = linkToLecture;
    }

    @Override
    public String toString() {
        return " TheoreticalPrivateLesson{" +
                "linkToLecture=" + linkToLecture +
                '}';
    }
}
