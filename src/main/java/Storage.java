import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage {
    private String filename;

    public Storage(String filename) {
        this.filename = filename;
    }

    public List<Task> load() throws DukeException {
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(this.filename));
            List<Task> tasks = new ArrayList<>();

            String line;
            while ((line = inStream.readLine()) != null) {
                List<String> words = Arrays.asList(line.split("\\|"));
                switch (words.get(0)) {
                    case "T":
                        tasks.add(new Todo(words.get(2)));
                        break;
                    case "E":
                        tasks.add(new Event(words.get(2), words.get(3)));
                        break;
                    case "D":
                        tasks.add(new Deadline(words.get(2), words.get(3)));
                        break;
                }
                if (words.get(1).equals("1")) tasks.get(tasks.size()-1).markAsDone();
            }
            return tasks;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound, creating new file...");
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return new ArrayList<>();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds exception: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void save(List<Task> tasks) {
        try {
            BufferedWriter outStream = new BufferedWriter(new FileWriter(this.filename));
            for (Task task : tasks) {
                outStream.write(task.saveFormat());
                outStream.newLine();
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
