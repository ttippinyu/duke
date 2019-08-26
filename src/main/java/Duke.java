import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Duke {
    private static List<Task> list = new ArrayList<>();

    private static void printIndent(String line) {
        System.out.println("    " + line);
    }

    private static void printUnderline() {
        printIndent("____________________________________________________________");
    }

    private static void addTask(Task task) {
        printUnderline();
        printIndent("Got it. I've added this task:");
        printIndent("   " + task);
        printIndent("Now you have " + list.size() + (list.size() == 1 ? " task " : " tasks ") + "in the list.");
        printUnderline();
    }

    private static void action(String actionType, String description) {
        switch(actionType) {
            case "todo":
                list.add(new Todo(description));
                addTask(list.get(list.size()-1));
                break;
            case "deadline":
                List<String> content = Arrays.asList(description.split(" /by "));
                list.add(new Deadline(content.get(0), content.get(1)));
                addTask(list.get(list.size()-1));
                break;
            case "event":
                content = Arrays.asList(description.split(" /at "));
                list.add(new Event(content.get(0), content.get(1)));
                addTask(list.get(list.size()-1));
                break;
        }
    }

    private static void startDuke() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            List<String> words = Arrays.asList(input.split(" "));

            if (input.equals("bye")) {
                printUnderline();
                printIndent("Bye. Hope to see you again soon!");
                printUnderline();
                return;
            } else if (input.equals("list")) {
                int counter = 1;
                printUnderline();
                printIndent("Here are the tasks in your list:");
                for (Task x : list) {
                    printIndent(counter + ". " + x);
                    counter++;
                }
                printUnderline();
            } else if (words.get(0).equals("done")) {
                int index = Integer.parseInt(words.get(1)) - 1;
                list.get(index).markAsDone();
                printUnderline();
                printIndent("Nice! I've marked this task as done:");
                printIndent("   " + list.get(index).toString());
                printUnderline();
            } else {
                action(words.get(0), input.substring(input.indexOf(" ")+1));
            }
        }
    }

    public static void main(String[] args) {
        printUnderline();
        printIndent("Hello! I'm Duke");
        printIndent("What can I do for you?");
        printUnderline();
        startDuke();
    }

}
