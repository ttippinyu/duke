import java.util.List;

public class TaskList {
    private List<Task> tasks;

    /**
     * Create the object based on list of tasks
     * @param tasks list of tasks to create object from
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gives the list object of tasks
     * @return list object of tasks
     */
    public List<Task> getList() {
        return tasks;
    }

    /**
     * Gives the task at index i
     * @param index the index of task to be returned
     * @return the task at index i
     */
    public Task get(int index) { return tasks.get(index); }

    /**
     * Removes the task at index i
     * @param index the index of task to be removed
     */
    public void remove(int index) { tasks.remove(index); }

    /**
     * Gives size of list
     * @return size of list
     */
    public int size() { return tasks.size(); }

    /**
     * Add task to end of list
     * @param task task to be added
     */
    public void add(Task task) { tasks.add(task); }
}
