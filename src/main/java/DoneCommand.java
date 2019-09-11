public class DoneCommand extends Command {
    private int index;

    /**
     * Creates command object for marking task as done
     * @param index index of task to mark as done
     */
    public DoneCommand(Integer index) {
        this.index = index;
    }

    /**
     * Mark the task at index as done
     * @param taskList task list object that the task to be marked as done is from
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            taskList.get(index).markAsDone();
            ui.showDone(taskList.get(index));
            storage.save(taskList.getList());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task number is invalid :((");
        }
    }
}
