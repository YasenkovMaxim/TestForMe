import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

      /*  System.out.println("Напишите номер занятия, в котором хотите увидеть результаты задач");
        Scanner scanner = new Scanner(System.in);
        int numberScanner = scanner.nextInt();
        switch (numberScanner) {
            case 1 -> LessonOne.lessonOne();
            case 2 -> LessonTwo.lessonTwo();
            case 3 -> LessonThree.lessonThree();
            case 5 -> LessonFive.lessonFive();
            default -> System.out.println("Такого занятия нет");
        }
        System.out.println();*/
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader("C:\\Users\\jasen\\Downloads\\example.txt")) {
            int i = 0;
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        //System.out.println(sb);

        String harryPotter = sb.toString();
        HashMap<String, Integer> harryPotterMap = new HashMap<>();

        Pattern pattern = Pattern.compile("\\w{2,}");
        Matcher matcher = pattern.matcher(harryPotter);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            harryPotterMap.put(word, harryPotterMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(harryPotterMap.get("wheezed"));
        harryPotterMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(100)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}