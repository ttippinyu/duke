public class AddEventCommand extends Command {
    private String description;
    private String date;

    public AddEventCommand(String description, String date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.add(new Event(this.description, this.date));
        ui.showAddTask(taskList.get(taskList.size() - 1), taskList.size());
        storage.save(taskList.getList());
    }
}
