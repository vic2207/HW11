package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {


    public static String getOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> (index + 1) + ". " + names.get(index))
                .collect(Collectors.joining(", "));
    }


    public static List<String> sortStringsInUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }


    public static String getSortedNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }


    public static Stream<Long> generateRandomStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterable<T> iterable = () -> new Iterator<T>() {
            private boolean useFirst = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() || secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (useFirst && firstIterator.hasNext()) {
                    useFirst = false;
                    return firstIterator.next();
                } else if (secondIterator.hasNext()) {
                    useFirst = true;
                    return secondIterator.next();
                }
                throw new IllegalStateException("No more elements");
            }
        };

        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "John", "Mike", "Alex");
        System.out.println("Завдання 1: " + getOddIndexedNames(names));

        List<String> strings = List.of("apple", "banana", "cherry");
        System.out.println("Завдання 2: " + sortStringsInUpperCase(strings));

        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println("Завдання 3: " + getSortedNumbers(array));

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 1;
        System.out.println("Завдання 4:");
        generateRandomStream(a, c, m, seed).limit(10).forEach(System.out::println);

        Stream<String> first = Stream.of("A", "B", "C");
        Stream<String> second = Stream.of("1", "2", "3", "4");
        System.out.println("Завдання 5:");
        zip(first, second).forEach(System.out::println);
    }
}
