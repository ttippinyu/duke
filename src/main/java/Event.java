import java.util.Arrays;
import java.util.List;

public class Event extends Task {
    private DateTime start;
    private DateTime end;

    /**
     * Creates the event object
     * @param description the description of the event
     * @param inputDate the datetime of the event
     * @throws DukeException if the format of the datetime is wrong
     */
    public Event(String description, String inputDate) throws DukeException {
        super(description);
        List<String> dates = Arrays.asList(inputDate.split(" to "));
        try {
            start = new DateTime(dates.get(0));
            end = new DateTime(dates.get(1));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid date format: dd/mm/yy hh:mm to dd/mm/yy hh:mm");
        }
    }

    /**
     * The string format of the object
     * @return [E] description (at: datetimeStart to datetimeEnd)
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.start.toString() + " to " + this.end.toString() + ")";
    }

    /**
     * The string format of the object saved into the file
     * @return E|description|datetimeStart to datetimeEnd
     */
    @Override
    public String saveFormat() {
        return "E|" + super.saveFormat() + "|" + this.start.toString() + " to " + this.end.toString();
    }
}
