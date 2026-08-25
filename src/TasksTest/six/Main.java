package TasksTest.six;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       /* // Дан List<Integer>. Оставь только четные числа, отсортируй их по убыванию и собери в новый список.
        List<Integer> numbers = Arrays.asList(10, null, 4, 20, 3, 15, 7, 16);
        List<Integer> newNumbers = Optional.ofNullable(numbers)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(newNumbers);

        //Дан список чисел. Найди максимальное число. Если список пустой или null — верни 0
        List<Integer> numbers2 = Arrays.asList(4, 9, 2, 15, 7, 11);

        Integer max = Optional.ofNullable(numbers2)
                .orElse(Collections.emptyList())
                .stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max);

        //Оставь только нечетные числа
        //Отсортируй их по возрастанию
        //Собери в новый список
        List<Integer> numbers3 = Arrays.asList(3, 7, 1, 9, 4, 6, 8, 2, 5);
        List<Integer> result = numbers3.stream()
                .filter(e -> e % 2 != 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);

        //Оставь только те строки, длина которых больше 3 символов
        //Преобразуй их в верхний регистр
        //Собери в новый список
        List<String> words = Arrays.asList("java", "python", "javascript", "c", "go", "rust");
        List<String> resultWords = words.stream()
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("После фильтра: " + e))
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(resultWords);


        //Оставь только числа, которые делятся на 3 (без остатка)
        //
        //Увеличь каждое число в 2 раза
        //
        //Найди сумму всех полученных чисел
        List<Integer> numbers4 = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40);
        Integer sum = numbers4.stream()
                .filter(e -> e % 3 == 0)
                .map(e -> e * 2)
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(sum);

//Оставь только те слова, которые содержат букву 'a' (в любом регистре)
//
//Посчитай общее количество букв 'a' во всех оставшихся словах (суммарно)
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        long count = words2.stream()
                .filter(word -> word.toLowerCase().contains("a"))
                .flatMapToInt(word -> word.chars())
                .filter(ch -> ch == 'a')
                .count();

        System.out.println("Слова с 'a': " + count);*/

//Сгруппируй людей по возрасту (age) в Map<Integer, List<Person>>
//
//Для каждой группы подсчитай количество людей этого возраста
//
//Выведи результат на экран в формате: {25=2, 30=2, 35=1, 40=1}
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 35),
                new Person("Eve", 30),
                new Person("Frank", 40));
        Map<Integer, List<Person>> groupByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupByAge);
        java.util.Map<Integer, Long> ageCount = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(ageCount);

        //Сгруппируй продукты по категории (category) в Map<String, List<Product>>
        //
        //Для каждой категории подсчитай количество продуктов
        //
        //Выведи результат на экран в формате: {Electronics=3, Clothing=3, Footwear=1}
        //Найти общую стоимость товаров в каждой категории
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("Shirt", "Clothing", 50),
                new Product("Jeans", "Clothing", 80),
                new Product("Sneakers", "Footwear", 120),
                new Product("TV", "Electronics", 1500),
                new Product("Jacket", "Clothing", 200)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(groupedByCategory);

        Map<String, Long> groupedByCategoryAndCount = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(groupedByCategoryAndCount);

        // Найти среднюю цену товара в каждой категории
        Map<String, Integer> groupedByCategoryAndSumProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingInt(Product::getPrice)));
        System.out.println(groupedByCategoryAndSumProducts);

        Map<String, Double> groupedByCategoryAndAveragePrise = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println(groupedByCategoryAndAveragePrise);

        //Найти самый дорогой товар в каждой категории
        Map<String, Optional<Product>> groupedByCategoryAndMaxPrice = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingInt(Product::getPrice))));
        System.out.println(groupedByCategoryAndMaxPrice);
    }
}
