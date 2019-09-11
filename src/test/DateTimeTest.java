import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeTest {
    @Test
    public void formatTest() {

        public List<String> dateStrings = new ArrayList<>(Arrays.asList(
                "23/09/19 11:00",
                "23/09/19 13:00",
                "27/09/19 23:59"
        ));

        public List<String> dateFormatted = new ArrayList<>(Arrays.asList(
                "23/09/2019 11:00",
                "23/09/2019 13:00",
                "27/09/2019 23:59"
        ));

        for (int i=0; i<3; i++) {
            assertEquals(dateStrings.get(i).toString(), dateFormatted.get(i));
        }
    }
}