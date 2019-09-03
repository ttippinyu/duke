import java.util.*;

public class Duke {
    private static List<Task> tasks = new ArrayList<>();
    private static Storage data = new Storage("data.txt");

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
        printIndent("Now you have " + tasks.size() + (tasks.size() == 1 ? " task " : " tasks ") + "in the list.");
        printUnderline();
    }

    private static void handleCommand(String actionType, String description) throws DukeException {
        if (actionType.equals("todo")) {
            tasks.add(new Todo(description));
            addTask(tasks.get(tasks.size() - 1));
        } else if (actionType.equals("deadline")) {
            List<String> content = Arrays.asList(description.split(" /by "));

            if (content.size() == 1) {
                System.out.println(content.get(0));
                throw new DukeException("Please supply a description or date");
            }

            tasks.add(new Deadline(content.get(0), content.get(1)));
            addTask(tasks.get(tasks.size() - 1));
        } else if (actionType.equals("event")) {
            List<String> content = Arrays.asList(description.split(" /at "));

            if (content.size() == 1) {
                throw new DukeException("Please supply a description or date");
            }

            tasks.add(new Event(content.get(0), content.get(1)));
            addTask(tasks.get(tasks.size() - 1));
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    private static void startDuke() {
        Scanner scanner = new Scanner(System.in);

        try {
            tasks = data.load();
        } catch (DukeException e) {
            printUnderline();
            printIndent(e.getMessage());
            printUnderline();
        }

        while (true) {
            String input = scanner.nextLine();
            List<String> words = Arrays.asList(input.split(" "));

            // bye
            if (input.equals("bye")) {
                printUnderline();
                printIndent("Bye. Hope to see you again soon!");
                printUnderline();
                return;

            // list
            } else if (input.equals("list")) {
                int counter = 1;
                printUnderline();
                printIndent("Here are the tasks in your list:");
                for (Task x : tasks) {
                    printIndent(counter + ". " + x);
                    counter++;
                }
                printUnderline();

            // done
            } else if (words.get(0).equals("done")) {
                try {
                    int index = Integer.parseInt(words.get(1)) - 1;
                    tasks.get(index).markAsDone();
                    printUnderline();
                    printIndent("Nice! I've marked this task as done:");
                    printIndent("   " + tasks.get(index).toString());
                    printUnderline();
                } catch (IndexOutOfBoundsException e) {
                    printUnderline();
                    printIndent("The task number is invalid :((");
                    printUnderline();
                }

            // find
            } else if (words.get(0).equals("find")) {
                try {
                    if (words.size() < 2)
                        throw new DukeException("Sorry, you need to add a keyword.");

                    String keyword = String.join(" ", words.subList(1, words.size()));

                    List<Task> found = new ArrayList<>();
                    for (Task task : tasks)
                        if (task.containsKeyword(keyword))
                            found.add(task);

                    int counter = 1;
                    printUnderline();
                    printIndent("HHere are the matching tasks in your list:");
                    for (Task x : found) {
                        printIndent(counter + ". " + x);
                        counter++;
                    }
                    printUnderline();

                } catch (DukeException e) {
                    printUnderline();
                    printIndent(e.getMessage());
                    printUnderline();
                }

            // actions
            } else {
                try {
                    String actionType = words.get(0);
                    String description = input.substring(input.indexOf(" ") + 1);

                    // if no description
                    if (description.equals(input)) {
                        if (description.equals("todo") || description.equals("deadline") || description.equals("event") )
                        throw new DukeException("☹ OOPS!!! The description cannot be empty.");
                    }

                    handleCommand(actionType, description);

                } catch (DukeException e) {
                    printUnderline();
                    printIndent(e.getMessage());
                    printUnderline();
                }
            }

            data.save(tasks);
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
