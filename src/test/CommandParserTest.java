import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandParserTest {
    @Test
    public void commandTest() {
        Parser parser = new Parser();

        public List<String> commandStrings = new ArrayList<>(Arrays.asList(
                "todo read book",
                "event Sports /at 23/09/19 11:00 to 23/09/19 13:00",
                "deadline Task /by 27/09/19 23:59",
                "list",
                "bye",
                "find a",
                "done 1",
                "delete 1"
        ));

        public List<Command> commandTypes = new ArrayList<>(Arrays.asList(
                new AddTodoCommand("read book"),
                new AddEventCommand("Sports", "23/09/19 11:00 to 23/09/19 13:00"),
                new AddDeadlineCommand("Task", "27/09/19 23:59"),
                new ListCommand(),
                new ExitCommand(),
                new FindCommand("a"),
                new DoneCommand(1),
                new DeleteCommand(1)
        ));

        for (int i=0; i<8; i++) {
            assertEquals(Parser.parse(commandStrings.get(i)), commandTypes.get(i));
        }
    }
}