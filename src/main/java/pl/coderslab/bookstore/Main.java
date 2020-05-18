package pl.coderslab.bookstore;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*List<String> users = Arrays.asList("Artem", "Tomek", "Gosia", "Szymon", "Marek");

        Random r = new Random();
        int i = r.nextInt(users.size());

        System.out.println(users.get(i));*/

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);

        Iterator<Integer> iterator = numbers.iterator();

        /*for (int number : numbers) {
            numbers.remove(0);
        }*/

       /* for (int i = 0; i < numbers.size(); i++) {
            numbers.remove(3);
        }*/
    }
}
