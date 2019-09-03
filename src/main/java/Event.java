import java.util.Arrays;
import java.util.List;

public class Event extends Task {
    private DateTime start;
    private DateTime end;

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

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.start.toString() + " to " + this.end.toString() + ")";
    }

    @Override
    public String saveFormat() {
        return "E|" + super.saveFormat() + "|" + this.start.toString() + " to " + this.end.toString();
    }
}
