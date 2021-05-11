package MPx;

import java.time.LocalDate;

public class StationaryPrivateLesson extends Mode{
    private String address;

    public StationaryPrivateLesson(String address,PrivateLesson privateLesson) throws Exception {
        super(privateLesson);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
