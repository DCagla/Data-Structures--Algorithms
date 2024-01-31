import java.util.Comparator; // Comparator'ü import ediyoruz

public class Main {
    static class NameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p2.getName().compareTo(p1.getName());
        }
    }

    static class SurnameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p2.getSurname().compareTo(p1.getSurname());
        }
    }

    public static void main(String[] args) {
        Person[] people = new Person[10];
        people[0] = new Person("Cağla", "Sarısu", 97234578941L);
        people[1] = new Person("Galip", "Banko", 99054678903L);
        people[2] = new Person("Dila", "Yaren",20987654321L);
        people[3] = new Person("Helin", "Taşdelen", 30196789032L);
        people[4] = new Person("Meryem", "Kısa", 80713459876L);
        people[5] = new Person("Ali", "Serhat", 40249876543L);
        people[6] = new Person("Leyla", "Kahya", 70421234567L);
        people[7] = new Person("Ceren", "Özçelik", 50953459871L);
        people[8] = new Person("Derya", "Akın", 10017123456L);
        people[9] = new Person("Burak", "İloğlu", 60459876123L);

        System.out.println("Sorted by ID (MergeSort):");
        MergeSort.sort(people);
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nSorted by Name (MergeSort):");
        MergeSort.sort(people, new NameComparator());
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nSorted by Surname (QuickSort):");
        QuickSort.sort(people, new SurnameComparator());
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
