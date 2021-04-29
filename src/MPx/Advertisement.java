package MPx;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.List;

public class Advertisement extends ObjectPlusPlus implements Serializable {
    private String tittle;
    private String content;
//    private  Student studentsAuthor;

    public Advertisement(String tittle, String content,Student student){
        this.tittle = tittle;
        this.content = content;
        createAPart(student,this);
    }

    public static void createAPart(Student student,Advertisement advertisement) {
        try {
            if (student == null) throw new Exception("required object - student");
            student.addPart(Roles.PART,Roles.WHOLE,advertisement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public void setStudentsAuthor(Student studentsAuthor) {
//        this.studentsAuthor = studentsAuthor;
//    }


    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }

//    public Student getStudentsAuthor() {
//        return studentsAuthor;
//    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
//                ", studentsAuthor=" + studentsAuthor.getName() +
                '}';
    }

}
