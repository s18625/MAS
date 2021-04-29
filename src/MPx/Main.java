package MPx;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {


        //==============================================================================================================
        //== stworzenie paru obiektow ==================================================================================
        //==============================================================================================================

//        var student2 = new Student("przykładowy2", "student2", LocalDate.of(1989, 12, 23), "s6969");
//        var coach = new Coach("przykładowy", "coach", LocalDate.of(2000, 1, 1), 2020, 30.0);
//        var coach2withNullField = new Coach("przykładowy", "coach2withNull", LocalDate.of(1990, 2, 12), null, 45.0);
//

        //==============================================================================================================
        //===========================   MP1    =========================================================================
        //==============================================================================================================

        String nameOfSerializedFile = "mp1.bin";
//        printBreakBlock();
//
//        //==============================================================================================================
//        //=====  atrybut zlozony =======================================================================================
//        //==============================================================================================================
//
//        var atrybutZlozony = student.getDateOfBirth();
//        System.out.println("atrybut zlozony - " + atrybutZlozony);
//        printBreakBlock();
//
//
//        //==============================================================================================================
//        //atrybut opcjonalny ===========================================================================================
//        //==============================================================================================================
//
//        var atrybutOpcjonalny = coach2withNullField.getYearOfGraduationPJATK();
//        var atrybutOpcjonalny2 = coach.getYearOfGraduationPJATK();
//        System.out.println("Atrybut opcjonalny z nullem - " + atrybutOpcjonalny);
//        System.out.println("Atrybut opcjonalny2 - " + atrybutOpcjonalny2);
//        printBreakBlock();
//
//        //==============================================================================================================
//        //atrybut powtarzalny ==========================================================================================
//        //==============================================================================================================
//
////        var atrybutPowtarzalny = coach.getKnownSubjects();
////        System.out.println("Atrybut powtarzalny: \n \t" + atrybutPowtarzalny);
//        printBreakBlock();
//
//        //==============================================================================================================
//        //atrybut klasowy ==============================================================================================
//        //==============================================================================================================
//
//        var aKlasowy = Coach.getMinimalYearOfBirth();
//        System.out.println("Atrybut klasowy - " + aKlasowy);
//        printBreakBlock();
//
//        //==============================================================================================================
//        //atrybut pochodny ==============================================================================================
//        //==============================================================================================================
//
//        var aPochodny = student.getAge();
//        System.out.println("Atrybut pochodny(wyliczalny wiek) - " + aPochodny);
//        printBreakBlock();
//
//        //==============================================================================================================
//        // metoda klasowa ==============================================================================================
//        //==============================================================================================================
//
//        System.out.println("Metoda Klasowa(najstarszy student):");
//        try {
//            var mKlasowa = Student.findTheOldestStudent();
//            System.out.println(mKlasowa);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        printBreakBlock();
//
//        //============================================================================================================
//        //PRZECIĄŻENIE================================================================================================
//        //============================================================================================================
//
//        coach.givePrivateLesson();
//        coach.givePrivateLesson(1.3);
//        System.out.println("Przeciążenie metody givePrivateLesson() - " + coach.getHoursOfTeaching());
//        printBreakBlock();
//
//        //============================================================================================================
//        //PRZESŁONIĘCIE===============================================================================================
//        //============================================================================================================
//
//        System.out.println("Przesłonięta metoda toString() - " + coach);
//        printBreakBlock();
//
//        //============================================================================================================
//        //ekstensje z seerailizacja ==================================================================================
//        //============================================================================================================
//

//        ObjectPlusPlus.deleteTheExtens(student2);
//
//        System.out.println("Serializacja ekstensji:");
//
//        try (
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nameOfSerializedFile));
//                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nameOfSerializedFile))
//        ) {
//            ObjectPlus.writeExtents(objectOutputStream);
//            ObjectPlus.readExtents(objectInputStream);
//
//            var extent = ObjectPlus.getExtentOfClass(Student.class);
//            extent.forEach(System.out::println);
//
//            var extentCoach = ObjectPlus.getExtentOfClass(Coach.class);
//            extentCoach.forEach(System.out::println);
//
//            printBreakBlock();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        //==============================================================================================================
        //   MP2
        //==============================================================================================================

        var student3 = new Student("student3", "mp2", LocalDate.of(2000, 3, 4));
        var student4 = new Student("student4", "mp2", LocalDate.of(1000, 11, 7));
        var coach = new Coach("przykładowy", "coach", LocalDate.of(2000, 1, 1), 2020, 30.0);
        var coach3 = new Coach("coach3", "mp2", LocalDate.of(1998, 12, 2), 2020, 33);
        Hobby hobby1Football = new Hobby("football");
        Hobby hobby2skate = new Hobby("skateboarding");
        Subject ppj = new Subject("PPJ", "Podstawy Programowania w Javie");
        Subject mad = new Subject("MAD", "Matemetytka Dyskretna");
        Subject grk = new Subject("GRK", "Grafika Komputerowa");

        printBreakBlock();

        //==============================================================================================================
        //   Asoscjacja "zwykla"
        //==============================================================================================================

        System.out.println("Asocjacja zwykła  \n");

        student3.addLink(Roles.HOBBY, Roles.STUDENT, hobby1Football);
        student3.addLink(Roles.HOBBY, Roles.STUDENT, hobby2skate);
        student4.addLink(Roles.HOBBY, Roles.STUDENT, hobby1Football);
        student3.showLinks(Roles.HOBBY, System.out);
        hobby1Football.showLinks(Roles.STUDENT, System.out);

        printBreakBlock();

        //==============================================================================================================
        //  Asoscjacja z atrybutem
        //==============================================================================================================

        System.out.println("Asocjacja z atrybutem \n");

        var privateLesson = new PrivateLesson(null, 25.0, 1.0, LocalDate.now(), coach3, student3);

        privateLesson.showLinks(Roles.STUDENT, System.out);
        privateLesson.showLinks(Roles.COACH, System.out);

        printBreakBlock();

        //==============================================================================================================
        //  Asoscjacja kwalifikowana
        //==============================================================================================================

        System.out.println("Asocjacja kwalifikowana \n");

        coach.addLink(Roles.SUBJECT, Roles.COACH, ppj, ppj.getAcronym());
        coach.addLink(Roles.SUBJECT, Roles.COACH, mad, mad.getAcronym());

        coach.showSubjectByAcronym(mad.getAcronym());


        printBreakBlock();

        //==============================================================================================================
        //  kompozycja
        //==============================================================================================================

        System.out.println("Asocjacja - kompozycja \n");

        Advertisement advertisement1 = new Advertisement("tytul1", "content1", student3);
        Advertisement advertisement2 = new Advertisement("tytul2", "content2", student3);

        advertisement1.showLinks(Roles.WHOLE, System.out);
        student3.showLinks(Roles.PART, System.out);

        printBreakBlock();


        //==============================================================================================================
        //  sparwdzenie czy dziala usuwanie dla kompozycji
        //==============================================================================================================

        var students = ObjectPlus.getExtentOfClass(Student.class);
        students.forEach(System.out::println);
        var ads = ObjectPlus.getExtentOfClass(Advertisement.class);
        ads.forEach(System.out::println);
        student3.deleteObject(student3,Roles.PART);
        System.out.println("///////////////////////");
        var students2 = ObjectPlus.getExtentOfClass(Student.class);
        students2.forEach(System.out::println);
        var ads2 = ObjectPlus.getExtentOfClass(Advertisement.class);
        ads2.forEach(System.out::println);
        System.out.println("///////////////////////");
        student3.showLinks(Roles.PART,System.out);
        System.out.println("///////////////////////");
        advertisement1.showLinks(Roles.WHOLE,System.out);

        //==============================================================================================================
        //  MP3
        //==============================================================================================================



    }


    static void printBreakBlock() {
        String breakString = """
                        
                ================================================================================================================================================================================================
                """;
        System.out.println(breakString);
    }
}
