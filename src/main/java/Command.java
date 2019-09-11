abstract public class Command {
    protected boolean isExit;

    /**
     * Check status of isExit flag
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Adding the object into task list
     * @param taskList task list object that object will be added into
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
    abstract public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;
}
