package TasksTest.two;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("Jon", 23, "dgffds@sdf.com");
        persons[1] = new Person("Sem", 57, "dgffds@sf.com");
        persons[2] = new Person("Katia", 4, "dgds@sdf.com");
        // System.out.println(Arrays.toString(persons));можно так
        int age = 0;
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
            if (age < persons[i].getAge()) {
                age = persons[i].getAge();
            }
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() == age) {
                System.out.println("Самый старший Person: " + persons[i].toString());
            }
        }
        Person person1 = new Person("Ilia", 25, "ilia@yandex.com");
        Person person2 = new Person("Ilia", 25, "ilia@yandex.com");
        System.out.println(person1.equals(person2));
        System.out.println("Количество созданных Person: " + Person.counter);
    }
}
