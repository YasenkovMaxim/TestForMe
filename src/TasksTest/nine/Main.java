package TasksTest.nine;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите сторку со разными скобочками: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (isBalanced(string)) {
            System.out.println("СБАЛАНСИРОВАНА");
        } else {
            System.out.println("НЕ СБАЛАНСИРОВАНА");
        }

    }

    public static boolean isBalanced(String str) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (Character c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (deque.isEmpty()) {
                    return false;
                }
                Character s = deque.pop();
                if (s == '(' && c != ')') return false;
                if (s == '[' && c != ']') return false;
                if (s == '{' && c != '}') return false;
            }
        }
        return deque.isEmpty();
    }
}