public class AddTodoCommand extends Command {
    private String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.add(new Todo(description));
        ui.showAddTask(taskList.get(taskList.size() - 1), taskList.size());
        storage.save(taskList.getList());
    }
}
