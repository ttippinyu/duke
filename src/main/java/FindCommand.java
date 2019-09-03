import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        List<Task> found = new ArrayList<>();
        for (Task task : taskList.getList())
            if (task.containsKeyword(keyword))
                found.add(task);

        ui.showFind(found);
    }
}
