public class DeleteCommand extends Command {
    private int index;

    /**
     * Creates command object for deleting task
     * @param index index of task
     */
    public DeleteCommand(Integer index) {
        this.index = index;
    }

    /**
     * Delete the task from the taskList
     * @param taskList task list object that the task will be removed from
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
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
