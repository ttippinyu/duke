import java.util.Date;

public class Deadline extends Task {
    private DateTime date;

    /**
     * Creates the deadline object
     * @param description the description of the deadline
     * @param inputDate the datetime of the deadline
     * @throws DukeException if the format of the datetime is wrong
     */
    public Deadline(String description, String inputDate) throws DukeException {
        super(description);
        date = new DateTime(inputDate);
    }

    /**
     * The string format of the object
     * @return [D] description (by: datetime)
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.date.toString() + ")";
    }

    /**
     * The string format of the object saved into the file
     * @return D|description|datetime
     */
    @Override
    public String saveFormat() {
        return "D|" + super.saveFormat() + "|" + this.date.toString();
    }
}