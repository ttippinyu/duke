import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testingAdd() {
        TaskList taskList = new TaskList();
        Task task = new Todo("Do work");
        taskList.add(task);

        assertEquals(taskList.get(0), task);
    }
}