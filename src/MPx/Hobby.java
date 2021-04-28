package MPx;

public class Hobby extends ObjectPlusPlus {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hobby(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'';
    }
}
