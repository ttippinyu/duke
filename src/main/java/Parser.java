import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    static public Command parse(String fullCommand) throws DukeException {
        List<String> words = Arrays.asList(fullCommand.split(" "));

        switch (words.get(0)) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "done":
                try {
                    int index = Integer.parseInt(words.get(1)) - 1;
                    return new DoneCommand(index);
                } catch (NumberFormatException e) {
                    throw new DukeException("Not a number");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("Please give a number");
                }
            case "delete":
                try {
                    int index = Integer.parseInt(words.get(1)) - 1;
                    return new DeleteCommand(index);
                } catch (NumberFormatException e) {
                    throw new DukeException("Not a number");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("Please give a number");
                }
            case "find":
                if (words.size() < 2)
                    throw new DukeException("Sorry, you need to add a keyword.");

                String keyword = String.join(" ", words.subList(1, words.size()));

                return new FindCommand(keyword);
            case "todo":
                String todoDescription = fullCommand.substring(words.indexOf(" ") + 1);
                todoDescription = todoDescription.trim();

                // if no description
                if (todoDescription.equals("todo")) {
                    throw new DukeException("☹ OOPS!!! The description cannot be empty.");
                }

                return new AddTodoCommand(todoDescription);
            case "deadline":
                String deadlineDescription = fullCommand.substring(words.indexOf(" ") + 1);
                if (deadlineDescription.equals("deadline")) {
                    throw new DukeException("☹ OOPS!!! The description cannot be empty.");
                }

                List<String> deadlineContent = Arrays.asList(deadlineDescription.split(" /by "));
                if (deadlineContent.size() == 1) {
                    throw new DukeException("Please supply a description or date");
                }

                return new AddDeadlineCommand(deadlineContent.get(0), deadlineContent.get(1));
            case "event":
                String eventDescription = fullCommand.substring(words.indexOf(" ") + 1);
                if (eventDescription.equals("event")) {
                    throw new DukeException("☹ OOPS!!! The description cannot be empty.");
                }

                List<String> eventContent = Arrays.asList(eventDescription.split(" /at "));
                if (eventContent.size() == 1) {
                    throw new DukeException("Please supply a description or date");
                }

                return new AddEventCommand(eventContent.get(0), eventContent.get(1));
            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
