package TasksTest.four;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileManager {

    public void writeToFile(String fileName, String content) {
        if (fileName == null) {
            throw new InvalidFileNameException("Error: FileName is null");
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFromFile(String fileName) {
        if (fileName == null) {
            throw new InvalidFileNameException("Error: FileName is null");
        }
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            int i = 0;
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendToFile(String fileName, String content) {
        if (fileName == null) {
            throw new InvalidFileNameException("Error: FileName is null");
        }
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(content);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public int countLines(String fileName) {
        try {
            return (int) Files.lines(Paths.get(fileName)).count();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return 0;
        }
    }
}
