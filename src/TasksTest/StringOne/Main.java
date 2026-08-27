package TasksTest.StringOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Написать метод, который переворачивает строку.

        String str = "Hello";

        char[] charString = str.toCharArray();
        char f;
        for (int i = 0; i <= charString.length / 2; i++) {
            f = charString[i];
            charString[i] = charString[charString.length - 1 - i];
            charString[charString.length - i - 1] = f;
        }
        System.out.println(Arrays.toString(charString));

        //Подсчитать количество гласных букв (a, e, i, o, u) в строке. Регистр не важен.
        String str2 = "HellO World and my first quest!";
        String strForWork = str2.toLowerCase();
        List<Character> vowelsFromStr2 = new ArrayList<>();
        for (Character c : strForWork.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelsFromStr2.add(c);
            }
        }
        System.out.println("Количество гласный букв в строке: " + vowelsFromStr2.size() + " " + vowelsFromStr2);

        //Найти первый неповторяющийся символ в строке. Если такого нет, вернуть '-'

        String str3 = "Mama";
        String newStr = str3.toLowerCase();
        List<Character> strForWork2 = new ArrayList<>();
        for (Character c : newStr.toCharArray()) {
            strForWork2.add(c);
        }
        boolean found = false;
        for (int i = 0; i < strForWork2.size(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < strForWork2.size(); j++) {
                if (i != j && strForWork2.get(i).equals(strForWork2.get(j))) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("Первый уникальный символ: " + strForWork2.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("-");
        }

        //Сжать строку, заменяя повторяющиеся символы на символ + количество повторений.

        String str4 = "aaaabbbcccccccc";
        char[] characters = str4.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < characters.length; i++) {
            int count = 1;
            while (i + 1 < characters.length && characters[i] == characters[i + 1]) {
                count++;
                i++;
            }
            result.append(characters[i]);
            result.append(count);
        }
        System.out.println("Сжатая строка: " + result);
        System.out.println("Оригинал: " + str4);
        if (result.length() < str4.length()) {
            System.out.println("Результат сжатия: " + result);
        } else {
            System.out.println("Сжатие неэффективно, оставляем: " + str4);
        }
    }
}
