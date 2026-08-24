package TasksTest.five;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maria", "IT"));
        employees.add(new Employee("John", "HR"));
        employees.add(new Employee("Maxim", "Marketing"));
        employees.add(new Employee("Ilya", "Sales"));
        employees.add(new Employee("Sasha", "Finance"));
        employees.add(new Employee("Katya", "IT"));
        employees.add(new Employee("Lena", "HR"));
        employees.add(new Employee("Sergey", "Finance"));
        employees.add(new Employee("Vasya", "HR"));

        System.out.println("   Все сотрудники:   ");
        employees.forEach(System.out::println);

        /*1*/
        System.out.println("   Cотрудники из отдела IT:   ");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .forEach(System.out::println);

        /*2*/
        System.out.println("   Cотрудники старше 30:   ");
        employees.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);

        /*3*/
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Средняя зарплата по всем сотрудникам: " + Math.round(averageSalary) + " рублей");

        /*4*/
        employees.stream()
                .max((s1, s2) -> Double.compare(s1.getSalary(), s2.getSalary()))
                .ifPresent(emp -> System.out.println("Сотрудник с максимальной зарплатой: " +
                        emp.getName() + " " + emp.getSalary()));

        /*5*/
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        /*6*/
        System.out.println("Средняя зарплата по отделам:");
        averageSalaryByDepartment.forEach((department, avgSalary) ->
                System.out.printf("%s: %.2f%n", department, avgSalary));

        /*7*/
        System.out.println("\n=== ТОП-3 СОТРУДНИКА ПО ЗАРПЛАТЕ ===");

        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Топ-3 сотрудника по зарплате:");
        for (int i = 0; i < top3.size(); i++) {
            Employee emp = top3.get(i);
            System.out.printf("%d место: %s (отдел: %s) - %.2f%n",
                    i + 1, emp.getName(), emp.getDepartment(), emp.getSalary());
        }

        /*8*/
        System.out.println("\n=== ПРОВЕРКА: ЕСТЬ ЛИ СОТРУДНИК С ИМЕНЕМ 'ИВАН'? ===");
        boolean hasIvan = employees.stream()
                .anyMatch(emp -> emp.getName().equals("Иван"));
        if (hasIvan) {
            System.out.println("Да, в компании есть сотрудник с именем Иван!");
        } else {
            System.out.println("Нет, в компании нет сотрудника с именем Иван.");
        }
    }
}
