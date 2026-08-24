package TasksTest.four;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String fileName ="C:\\Users\\jasen\\Desktop\\text.txt";
        File file = new File(fileName);

        TextFileManager fileManager = new TextFileManager();

        fileManager.writeToFile(fileName, "Привет меня зовут Максим.\n" +
                "Как твои дела?\n" +
                "Надеюсь у тебя все хорошо");
        System.out.println(fileManager.readFromFile(fileName));

        fileManager.appendToFile(fileName, " Добавление!!! ");
        System.out.println(fileManager.readFromFile(fileName));
        System.out.println("Количество строк: " + fileManager.countLines(fileName));
    }
}
