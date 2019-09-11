public class AddTodoCommand extends Command {
    private String description;

    /**
     * Creates command object for adding to do
     * @param description string of description of to do
     */
    public AddTodoCommand(String description) {
        this.description = description;
    }

    /**
     * Adding the to do object into task list
     * @param taskList the task list object the to do object will be added into
     * @param ui the Ui object used for the program
     * @param storage the Storage object used for the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.add(new Todo(description));
        ui.showAddTask(taskList.get(taskList.size() - 1), taskList.size());
        storage.save(taskList.getList());
    }
}
