package MPx;

public class Catholicism extends ObjectPlus4 {
    private final String nameOfGod = "God";
    private String pope = "Francesco";
    private static Catholicism instance;

    private Catholicism(String pope) {
        setPope(pope);
    }

    public static Catholicism getInstance(String pope){
        if (instance == null) instance = new Catholicism(pope);
        return instance;
    }

    public String getPope() {
        return pope;
    }

    public void setPope(String pope) {
        this.pope = pope;
    }

    public String getNameOfGod() {
        return nameOfGod;
    }

    @Override
    public String toString() {
        return "Catholicism{" +
                "nameOfGod='" + nameOfGod + '\'' +
                ", pope='" + pope + '\'' +
                '}';
    }
}
