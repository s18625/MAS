package MPx;

import java.time.LocalDate;

public class PracticalPrivateLesson extends  ObjectPlusPlus{
    private String linkToRepository;
    public PracticalPrivateLesson(String linkToRepository) {
        this.linkToRepository = linkToRepository;
    }

    public String getLinkToRepository() {
        return linkToRepository;
    }

    public void setLinkToRepository(String linkToRepository) {
        this.linkToRepository = linkToRepository;
    }

    @Override
    public String toString() {
        return " PracticalPrivateLesson{" +
                "linkToRepository='" + linkToRepository + '\'' +
                '}';
    }
}
