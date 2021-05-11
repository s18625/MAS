package MPx;

import java.math.BigInteger;

public class Islam extends ObjectPlus4 {
    private final String nameOfGod = "Allah";
    private BigInteger numberOfFollowers;
    private static Islam instance;

    private Islam(BigInteger numberOfFollowers) {
        setNumberOfFollowers(numberOfFollowers);
    }

    public static Islam getInstanceOfIslam(BigInteger numberOfFollowers){
        if (instance == null) instance = new Islam(numberOfFollowers);
        return instance;
    }

    public BigInteger getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(BigInteger numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    @Override
    public String toString() {
        return "Islam{" +
                "nameOfGod='" + nameOfGod + '\'' +
                ", numberOfFollowers=" + numberOfFollowers +
                '}';
    }
}
