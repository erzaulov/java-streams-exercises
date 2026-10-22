package com.example.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExercises {

    // Exercise 1: удалить дубликаты, сохранив порядок первого появления.
    public static <T> List<T> removeDuplicates(List<T> items) {
        return items.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Exercise 2: третье наибольшее число; повторы считаются отдельно.
    public static int thirdLargestIncludingDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Для упражнения 2 нужно минимум три числа"));
    }

    // Exercise 3: третье наибольшее уникальное число.
    public static int thirdLargestUnique(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Для упражнения 3 нужно минимум три уникальных числа"));
    }

    // Exercise 4: имена трёх самых старших инженеров по убыванию возраста.
    public static List<String> namesOfThreeOldestEngineers(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getPosition().equals("Инженер"))
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    // Exercise 5: средний возраст инженеров.
    public static double averageEngineerAge(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getPosition().equals("Инженер"))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);
    }

    // Exercise 6: самое длинное слово в списке.
    public static String longestWord(List<String> words) {
        return words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Список слов пуст"));
    }

    // Exercise 7: частота каждого слова в строке.
    public static Map<String, Long> countWords(String text) {
        if (text == null || text.isBlank()) {
            return Map.of();
        }

        return Arrays.stream(text.trim().split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    // Exercise 8: сортировка по длине, затем по естественному порядку.
    public static List<String> sortByLengthThenAlphabetically(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    // Exercise 9: самое длинное слово среди всех строк массива.
    public static String longestWordInLines(String[] lines) {
        return Arrays.stream(lines)
                .filter(line -> line != null && !line.isBlank())
                .flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new IllegalArgumentException(
                        "В массиве нет слов"));
    }
}
