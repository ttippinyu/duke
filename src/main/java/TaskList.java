import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getList() {
        return tasks;
    }

    public Task get(int index) { return tasks.get(index); }

    public void remove(int index) { tasks.remove(index); }

    public int size() { return tasks.size(); }

    public void add(Task task) { tasks.add(task); }
}
