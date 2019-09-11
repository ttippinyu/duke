import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    /**
     * Creates Ui object
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints indented form of line
     * @param line the line to be indented
     */
    public void printIndent(String line) {
        System.out.println("    " + line);
    }

    /**
     * Prints a line
     */
    public void showLine() {
        printIndent("____________________________________________________________");
    }

    /**
     * Prints the welcome message
     */
    public void showWelcome() {
        showLine();
        printIndent("Hello! I'm Duke");
        printIndent("What can I do for you?");
        showLine();
    }

    /**
     * Prints the exit message
     */
    public void showExit() {
        printIndent("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the error message
     * @param message the error message
     */
    public void showLoadingError(String message) {
        printIndent(message);
    }

    /**
     * Prints the error
     * @param message the error message
     */
    public void showError(String message) {
        printIndent(message);
    }

    /**
     * Reads the input
     * @return the string input
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Prints the message for marking a task as done
     * @param task the task that was marked as done
     */
    public void showDone(Task task) {
        printIndent("Nice! I've marked this task as done:");
        printIndent("   " + task.toString());
    }

    /**
     * Prints the message for deleting a task
     * @param task the task that was deleted
     * @param size the size of the list
     */
    public void showDeleted(Task task, int size) {
        printIndent("Noted. I've removed this task:");
        printIndent("   " + task.toString());
        printIndent("Now you have " + size + (size == 1 ? " task " : " tasks ") + "in the list.");
    }

    /**
     * Prints the list of tasks with numbers
     * @param tasks the list of tasks
     */
    public void showNumberedTasks(List<Task> tasks) {
        int counter = 1;
        for (Task x : tasks) {
            printIndent(counter + ". " + x);
            counter++;
        }
    }

    /**
     * Prints the list of all the tasks
     * @param tasks the list of tasks
     */
    public void showList(List<Task> tasks) {
        printIndent("Here are the tasks in your list:");
        showNumberedTasks(tasks);
    }

    /**
     * Prints the list of tasks that contain the keyword
     * @param tasks the list of tasks that contains the keyword
     */
    public void showFind(List<Task> tasks) {
        printIndent("Here are the matching tasks in your list:");
        showNumberedTasks(tasks);
    }

    /**
     * Prints the message for adding a task
     * @param task the task to be added
     * @param size the size of the list
     */
    public void showAddTask(Task task, int size) {
        printIndent("Got it. I've added this task:");
        printIndent("   " + task);
        printIndent("Now you have " + size + (size == 1 ? " task " : " tasks ") + "in the list.");
    }
}
