package MP1;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //==============================================================================================================
        //===========================   MP1    =========================================================================
        //==============================================================================================================

        String nameOfSerializedFile = "mp1.bin";
        printBreakBlock();

        //==============================================================================================================
        //== stworzenie paru obiektow ==================================================================================
        //==============================================================================================================

        var student = new Student("przykładowy", "student", LocalDate.of(1999, 1, 1), "s1111");
        var a= new Advertisement("tytul1","tresc1");
        student.addAdvertisement(a);
        var student2 = new Student("przykładowy2", "student2", LocalDate.of(1989, 12, 23), "s6969");
        var coach = new Coach("przykładowy", "coach", LocalDate.of(2000, 1, 1), 2020, List.of(Subject.MAD, Subject.PPJ), 30.0);
        var coach2withNullField = new Coach("przykładowy", "coach2withNull", LocalDate.of(1990, 2, 12), null, List.of(Subject.MAS), 45.0);

        //==============================================================================================================
        //atrybut zlozony ==============================================================================================
        //==============================================================================================================

        var atrybutZlozony = student.getDateOfBirth();
        System.out.println("atrybut zlozony - " + atrybutZlozony);
        printBreakBlock();


        //==============================================================================================================
        //atrybut opcjonalny ===========================================================================================
        //==============================================================================================================

        var atrybutOpcjonalny = coach2withNullField.getYearOfGraduationPJATK();
        var atrybutOpcjonalny2 = coach.getYearOfGraduationPJATK();
        System.out.println("Atrybut opcjonalny z nullem - " + atrybutOpcjonalny);
        System.out.println("Atrybut opcjonalny2 - " + atrybutOpcjonalny2);
        printBreakBlock();

        //==============================================================================================================
        //atrybut powtarzalny ==========================================================================================
        //==============================================================================================================

        var atrybutPowtarzalny = coach.getKnownSubjects();
        System.out.println("Atrybut powtarzalny - " + atrybutPowtarzalny);
        printBreakBlock();

        //==============================================================================================================
        //atrybut klasowy ==============================================================================================
        //==============================================================================================================

        var aKlasowy = Coach.getMinimalYearOfBirth();
        System.out.println("Atrybut klasowy - " + aKlasowy);
        printBreakBlock();

        //==============================================================================================================
        //atrybut pochodny ==============================================================================================
        //==============================================================================================================

        var aPochodny = student.getAge();
        System.out.println("Atrybut pochodny(wyliczalny wiek) - " + aPochodny);
        printBreakBlock();

        //==============================================================================================================
        // metoda klasowa ==============================================================================================
        //==============================================================================================================

        System.out.println("Metoda Klasowa(najstarszy student):");
        try {
            var mKlasowa = Student.findTheOldestStudent();
            System.out.println(mKlasowa);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        printBreakBlock();

        //==============================================================================================================
        //PRZECIĄŻENIE==================================================================================================
        //==============================================================================================================

        coach.givePrivateLesson();
        coach.givePrivateLesson(1.3);
        System.out.println("Przeciążenie metody givePrivateLesson() - " + coach.getHoursOfTeaching());
        printBreakBlock();

        //==============================================================================================================
        //PRZESŁONIĘCIE=================================================================================================
        //==============================================================================================================

        System.out.println("Przesłonięta metoda toString() - " + coach);
        printBreakBlock();

        //==============================================================================================================
        //ekstensje z seerailizacja ====================================================================================
        //==============================================================================================================

        System.out.println("Serializacja ekstensji:");
        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nameOfSerializedFile));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nameOfSerializedFile))
        ) {
            ObjectPlus.writeExtents(objectOutputStream);
            ObjectPlus.readExtents(objectInputStream);

            var extent = ObjectPlus.getExtentOfClass(Student.class);
            extent.forEach(System.out::println);

            var extentCoach = ObjectPlus.getExtentOfClass(Coach.class);
            extentCoach.forEach(System.out::println);

            printBreakBlock();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //==============================================================================================================
        //===========================   MP2    =========================================================================
        //==============================================================================================================





    }


    static void printBreakBlock() {
        String breakString = """
                        
                ================================================================================================================================================================================================
                """;
        System.out.println(breakString);
    }
}
