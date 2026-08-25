package TasksTest.seven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Война и мир", "Лев Толстой", 1869, "Роман", 1225),
                new Book("Преступление и наказание", "Фёдор Достоевский", 1866, "Роман", 672),
                new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, "Роман", 480),
                new Book("Доктор Живаго", "Борис Пастернак", 1957, "Роман", 704),
                new Book("Евгений Онегин", "Александр Пушкин", 1833, "Роман", 352),
                new Book("Десять негритят", "Агата Кристи", 1939, "Детектив", 256),
                new Book("Убийство в Восточном экспрессе", "Агата Кристи", 1934, "Детектив", 320),
                new Book("Собака Баскервилей", "Артур Конан Дойл", 1902, "Детектив", 288),
                new Book("Убить пересмешника", "Харпер Ли", 1960, "Детектив", 384),
                new Book("Дюна", "Фрэнк Герберт", 1965, "Фантастика", 896),
                new Book("451 градус по Фаренгейту", "Рэй Брэдбери", 1953, "Фантастика", 256),
                new Book("Сталкер", "Аркадий и Борис Стругацкие", 1972, "Фантастика", 384),
                new Book("Гиперболоид инженера Гарина", "Алексей Толстой", 1927, "Фантастика", 448),
                new Book("Автостопом по галактике", "Дуглас Адамс", 1979, "Фантастика", 224),
                new Book("Гордость и предубеждение", "Джейн Остин", 1813, "Роман", 432)
        );
        /*1 Сгруппировать книги по жанру в Map<String, List<Book>>*/
        Map<String, List<Book>> groupedByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
        groupedByGenre.forEach((genre, booksList) -> {
            System.out.println("Жанр: " + genre);
            System.out.println("Количество книг: " + booksList.size());
            booksList.forEach(book -> System.out.println("  - " + book));
            System.out.println();
        });

        /*2 Для каждого жанра подсчитать количество книг и вывести в формате: {Роман=5, Детектив=3, Фантастика=4}*/
        Map<String, Long> groupedByGenreAndCount = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
        groupedByGenreAndCount.forEach((genre, count) -> System.out.println(genre + " : " + count));

        /*3 Для каждого жанра найти среднее количество страниц*/
        Map<String, Double> groupedByGenreAndAveragePage = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.averagingInt(Book::getPages)));
        groupedByGenreAndAveragePage.forEach((genre, averagePage) -> System.out.println(genre +
                " : Среднее количество страниц - "
                + Math.round(averagePage)));

        /*4 Найти самую старую и самую новую книгу в каждом жанре (по году издания)*/
        Map<String, Optional<Book>> groupedByGenreAndMax = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.maxBy((Comparator.comparingInt(Book::getYear)))));
        groupedByGenreAndMax.forEach((genre, maxYear) -> {
            System.out.println(genre + " : ");
            maxYear.ifPresent(e -> System.out.println(" Самая новая книга по году издания: " + e.getTitle() +
                    ". год издания: " + e.getYear()));
        });
        Map<String, Optional<Book>> groupedByGenreAndMin = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.minBy((Comparator.comparingInt(Book::getYear)))));
        groupedByGenreAndMin.forEach((genre, maxYear) -> {
            System.out.println(genre + " : ");
            maxYear.ifPresent(e -> System.out.println(" Самая старая книга по году издания: " + e.getTitle() +
                    ". год издания: " + e.getYear()));
        });

        /*5 Сгруппировать книги по автору и для каждого автора вывести список названий его книг*/
        Map<String, List<String>> groupedByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
        groupedByAuthor.forEach((s, authors) -> {
            System.out.println("Автор: " + s);
            authors.forEach(e -> System.out.println("Книги - " + e));
        });
    }
}
