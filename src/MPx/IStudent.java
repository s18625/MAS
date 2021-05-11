package MPx;

import java.util.Comparator;

public interface IStudent {

    String getIndexNumber();

    void rateTheCoach(Coach coach, double rating) throws Exception;
}
