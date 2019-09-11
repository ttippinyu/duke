import java.util.Arrays;
import java.util.List;

public class DateTime {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;

    /**
     * Converts the string format of datetime into the object DateTime
     * @param input the string for the datetime in dd/mm/yy hh:mm
     * @throws DukeException When the format of the input is wrong
     */
    public DateTime (String input) throws DukeException {
        List<String> dateTimeSplit = Arrays.asList(input.split(" "));

        //get the date
        try {
            String date = dateTimeSplit.get(0);
            String time = dateTimeSplit.get(1);

            List<String> dateParts = Arrays.asList(date.split("/"));
            this.day = Integer.parseInt(dateParts.get(0));
            this.month = Integer.parseInt(dateParts.get(1));
            this.year = Integer.parseInt(dateParts.get(2));

            List<String> timeParts = Arrays.asList(time.split(":"));
            this.hour = Integer.parseInt(timeParts.get(0));
            this.min = Integer.parseInt(timeParts.get(1));

            if (this.day < 0 || this.month < 0 || this.year < 0 || this.min < 0 || this.hour < 0 ||
                    this.day > 31 || this.month > 12 || this.hour > 23 || this.min > 59) {
                throw new DukeException("Invalid datetime value");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Invalid format: dd/mm/yy hh:mm");
        }
    }

    /**
     * Gives the string of the object
     * @return dd/mm/yyyy hh:mm
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d", this.day, this.month, this.year, this.hour, this.min);
    }
}
