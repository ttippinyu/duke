public class AddEventCommand extends Command {
    private String description;
    private String date;

    /**
     * Creates command object for adding event
     * @param description string of description of event
     * @param date string of date of event
     */
    public AddEventCommand(String description, String date) {
        this.description = description;
        this.date = date;
    }

    /**
     * Adding the event object into task list
     * @param taskList the task list object the event object will be added into
     * @param ui the Ui object used for the program
     * @param storage the Storage object used for the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.add(new Event(this.description, this.date));
        ui.showAddTask(taskList.get(taskList.size() - 1), taskList.size());
        storage.save(taskList.getList());
    }
}
