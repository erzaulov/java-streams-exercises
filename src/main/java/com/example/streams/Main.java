package com.example.streams;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Exercise 1 ===");
        List<Integer> numbersWithDuplicates = List.of(1, 2, 3, 2, 4, 1, 5);
        System.out.println(StreamExercises.removeDuplicates(numbersWithDuplicates));

        System.out.println("\\n=== Exercise 2 ===");
        List<Integer> numbers = List.of(5, 2, 10, 9, 4, 3, 10, 1, 13);
        System.out.println(StreamExercises.thirdLargestIncludingDuplicates(numbers));

        System.out.println("\\n=== Exercise 3 ===");
        System.out.println(StreamExercises.thirdLargestUnique(numbers));

        List<Employee> employees = List.of(
                new Employee("Анна", 35, "Инженер"),
                new Employee("Иван", 42, "Менеджер"),
                new Employee("Пётр", 50, "Инженер"),
                new Employee("Мария", 45, "Инженер"),
                new Employee("Олег", 30, "Инженер"),
                new Employee("Елена", 55, "Инженер")
        );

        System.out.println("\\n=== Exercise 4 ===");
        System.out.println(StreamExercises.namesOfThreeOldestEngineers(employees));

        System.out.println("\\n=== Exercise 5 ===");
        System.out.println(StreamExercises.averageEngineerAge(employees));

        System.out.println("\\n=== Exercise 6 ===");
        List<String> words = List.of("кот", "программирование", "дом", "разработчик");
        System.out.println(StreamExercises.longestWord(words));

        System.out.println("\\n=== Exercise 7 ===");
        System.out.println(StreamExercises.countWords("кот дом кот дерево дом кот"));

        System.out.println("\\n=== Exercise 8 ===");
        List<String> wordsToSort = List.of("груша", "дом", "арбуз", "кот", "банан", "лес");
        System.out.println(StreamExercises.sortByLengthThenAlphabetically(wordsToSort));

        System.out.println("\\n=== Exercise 9 ===");
        String[] lines = {
                "кот собака дом дерево машина",
                "река программирование лес компьютер стол",
                "море разработчик книга телефон окно"
        };
        System.out.println(StreamExercises.longestWordInLines(lines));
    }
}
