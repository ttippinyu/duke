public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(Integer index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            Task removed = taskList.get(index);
            taskList.remove(index);
            ui.showDeleted(removed, taskList.size());
            storage.save(taskList.getList());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task number is invalid :((");
        }
    }
}
