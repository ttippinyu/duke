public class DoneCommand extends Command {
    private int index;

    public DoneCommand(Integer index) {
        this.index = index;
    }

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
