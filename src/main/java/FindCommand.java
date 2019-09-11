import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    private String keyword;

    /**
     * Create command for finding task with keyword
     * @param keyword the keyword to find
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Find the tasks that contain keyword
     * @param taskList task list object to search from
     * @param ui the Ui object used by the program
     * @param storage the Storage object used by the program
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        List<Task> found = new ArrayList<>();
        for (Task task : taskList.getList())
            if (task.containsKeyword(keyword))
                found.add(task);

        ui.showFind(found);
    }
}
