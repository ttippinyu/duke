import java.util.Scanner;

public class Duke {


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

            if (input.equals("bye")) {
                printUnderline();
                printIndent("Bye. Hope to see you again soon!");
                printUnderline();
                return;
            } else {
                printUnderline();
                printIndent(input);
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
