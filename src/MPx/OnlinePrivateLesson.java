package MPx;

import java.time.LocalDate;

public class OnlinePrivateLesson extends Mode{
    private String platformName;
    public OnlinePrivateLesson(String platformName,PrivateLesson privateLesson) throws Exception {
        super(privateLesson);
        this.platformName= platformName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "OnlinePrivateLesson{" +
                "platformName='" + platformName + '\'' +
                '}';
    }
}
