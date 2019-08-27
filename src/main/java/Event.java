public class Event extends Task {
    String date;

    public Event(String description, String inputDate) {
        super(description);
        date = inputDate;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.date + ")";
    }

    @Override
    public String saveFormat() {
        return "E|" + super.saveFormat() + "|" + this.date;
    }
}
