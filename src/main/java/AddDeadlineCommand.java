public class AddDeadlineCommand extends Command {
    private String description;
    private String date;

    public AddDeadlineCommand(String description, String date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.add(new Deadline(this.description, this.date));
        ui.showAddTask(taskList.get(taskList.size() - 1), taskList.size());
        storage.save(taskList.getList());
    }
}
