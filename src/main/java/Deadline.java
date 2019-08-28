import java.util.Date;

public class Deadline extends Task {
    private DateTime date;

    public Deadline(String description, String inputDate) throws DukeException {
        super(description);
        date = new DateTime(inputDate);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.date.toString() + ")";
    }

    @Override
    public String saveFormat() {
        return "D|" + super.saveFormat() + "|" + this.date.toString();
    }
}