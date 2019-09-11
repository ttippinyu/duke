public class ListCommand extends Command {
    /**
     * Show the list of tasks
     * @param taskList task list object to show
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.showList(taskList.getList());
    }
}
