package demo;

import utils.ArrayUtils;
import utils.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex08 {
    public static void main(String[] args) {

        int[] digits = {1,2,3,2,4,6,4,8};
        // Stream Object: Stream<T>
        // Stream Primitive: IntStream, DoubleStream, LongStream.


        int[] arr = Arrays.stream(digits).filter(digit -> digit % 2 == 0)
                .distinct()
                .toArray();
        ArrayUtils.printf(arr);

        System.out.println("===================");
        /* List<Integer> numbers = Arrays.asList(1,2,3,2,4,6,4,8);

        Set<Integer> evenNumbers = numbers.stream()
                                            .filter(nbr -> nbr % 2 == 0 )
                                            //.distinct() // Set, Map , HashTable >> hashcode,equals
                                            .collect(Collectors.toSet());
        System.out.println("runtime class :"+evenNumbers.getClass().getSimpleName());
        CollectionUtils.printf(evenNumbers); */

        System.out.println("-------------------");
        // convert int[] -> List<Integer>

        List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());
        numbers.forEach(System.out::println);

        System.out.println("--------------------");
        List<Integer> uniqueNbrs = numbers.stream()
                .filter(nbr -> Collections.frequency(numbers,nbr) == 1) // Stream<Integer>
                .collect(Collectors.toList());



        CollectionUtils.printf(uniqueNbrs);

        System.out.println("--------------------");
        numbers.stream()
                .collect(Collectors.groupingBy( Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(integerLongEntry -> integerLongEntry.getKey())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("The stream after applying "
                + "the function is : ");

        // Creating a list of Integers
        List<String> list = Arrays.asList("geeks", "gfg", "g",
                "e", "e", "k", "s");

        // Using Stream map(Function mapper) to
        // convert the Strings in stream to
        // UpperCase form
        List<String> answer = list.stream().map(String::toUpperCase).
                collect(Collectors.toList());

        // displaying the new stream of UpperCase Strings
        System.out.println(answer);
    }


    }

