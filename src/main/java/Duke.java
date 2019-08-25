import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    private static List<Task> list = new ArrayList<>();

    private static void printIndent(String line) {
        System.out.println("    " + line);
    }

    private static void printUnderline() {
        printIndent("____________________________________________________________");
    }

    private static void startDuke() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            if (input.equals("bye")) {
                printUnderline();
                printIndent("Bye. Hope to see you again soon!");
                printUnderline();
                return;
            } else if (input.equals("list")) {
                int counter = 1;
                for (Task x : list) {
                    printIndent(counter + ". " + x);
                    counter++;
                }
            } else if (words[0].equals("done")) {
                int index = Integer.parseInt(words[1]) - 1;
                list.get(index).markAsDone();
                printUnderline();
                printIndent("Nice! I've marked this task as done:");
                printIndent("   " + list.get(index).toString());
                printUnderline();
            } else {
                printUnderline();
                printIndent("Added: " + input);
                list.add(new Task(input));
                printUnderline();
            }
        }
    }

    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        printUnderline();
        printIndent("Hello! I'm Duke");
        printIndent("What can I do for you?");
        printUnderline();
        startDuke();
    }

}
