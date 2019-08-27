public class Deadline extends Task {
    String date;

    public Deadline(String description, String inputDate) {
        super(description);
        date = inputDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.date + ")";
    }

    @Override
    public String saveFormat() {
        return "D|" + super.saveFormat() + "|" + this.date;
    }
}