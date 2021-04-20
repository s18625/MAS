package MP1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Advertisement implements Serializable {
    private String tittle;
    private String content;
    private  Student studentsAuthor;

    public Advertisement(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStudentsAuthor(Student studentsAuthor) {
        this.studentsAuthor = studentsAuthor;
    }


    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }

    public Student getStudentsAuthor() {
        return studentsAuthor;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", studentsAuthor=" + studentsAuthor.getName() +
                '}';
    }

}
