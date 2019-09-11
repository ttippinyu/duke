public class ExitCommand extends Command {
    /**
     * Create command for exit
     */
    public ExitCommand() {
        this.isExit = true;
    }

    /**
     * Exit the program
     * @param taskList task list used by the program
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.showExit();
    }
}
