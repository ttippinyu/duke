import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void printIndent(String line) {
        System.out.println("    " + line);
    }

    public void showLine() {
        printIndent("____________________________________________________________");
    }

    public void showWelcome() {
        showLine();
        printIndent("Hello! I'm Duke");
        printIndent("What can I do for you?");
        showLine();
    }

    public void showExit() {
        printIndent("Bye. Hope to see you again soon!");
    }

    public void showLoadingError(String message) {
        printIndent(message);
    }

    public void showError(String message) {
        printIndent(message);
    }

    public String readCommand() {
        return this.scanner.nextLine();
    }

    public void showDone(Task task) {
        printIndent("Nice! I've marked this task as done:");
        printIndent("   " + task.toString());
    }

    public void showDeleted(Task task, int size) {
        printIndent("Noted. I've removed this task:");
        printIndent("   " + task.toString());
        printIndent("Now you have " + size + (size == 1 ? " task " : " tasks ") + "in the list.");
    }

    public void showNumberedTasks(List<Task> tasks) {
        int counter = 1;
        for (Task x : tasks) {
            printIndent(counter + ". " + x);
            counter++;
        }
    }

    public void showList(List<Task> tasks) {
        printIndent("Here are the tasks in your list:");
        showNumberedTasks(tasks);
    }

    public void showFind(List<Task> tasks) {
        printIndent("Here are the matching tasks in your list:");
        showNumberedTasks(tasks);
    }

    public void showAddTask(Task task, int size) {
        printIndent("Got it. I've added this task:");
        printIndent("   " + task);
        printIndent("Now you have " + size + (size == 1 ? " task " : " tasks ") + "in the list.");
    }
}
