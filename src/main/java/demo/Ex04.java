package demo;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;

import java.util.*;
import java.util.function.Function;

import static utils.CollectionUtils.map;

public class Ex04 {
    public static void main(String[] args) {
        List<Apple> inventory = AppleUtils.getAll();

        /** inventory.forEach(apple -> System.out.println(apple.getWeight()));
         *
         */

        inventory.forEach(System.out::println);
        System.out.println();

        //
        System.out.println("=========== Map Length ==========");

        List<String> texts= Arrays.asList("abc","abcde","ab","abcdefgh");

        // (String s) -> s.length()
        Set<Integer> weights = map(texts, String:: length);
        CollectionUtils.printf(weights);


        // Example 03
        // s -> Integer.parseInt(s) ; > Integer::parseInt;
         Function<String,Integer> f1 = Integer::parseInt;


        compare(Collections.emptyList(),Collections.emptyList(), Apple::getId);
    }

    private static <R> boolean compare(List<Apple> la1, List<Apple> la2,Function<Apple,R> func){
        if (la1.size() != la2.size() ){
            return false;
        }
        int length = la1.size();

        for (int i = 0; i < length ; i++) {
            if (la1.get(i).getId() != la2.get(i).getId() ){
                return false;
            }
        }
        return true;

    }


}
