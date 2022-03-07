package demo;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

import java.util.*;
import java.util.function.Function;

import static utils.CollectionUtils.map;

public class Ex02 {
    public static <R, T> void main(String[] args) {


        List<Apple> inventory = AppleUtils.getAll();

        List<Apple> green = filterApple(inventory,(Apple apple) -> {
            return "green".equals(apple.getColor());
        });
        System.out.println("=====================");

        CollectionUtils.printf(green);

        System.out.println("=====================");

       /** Set<String> countries = map(inventory, new Function<Apple,String>() {
            @Override
            public String apply(Apple t) {
                return t.getCountry();
            }
        });

        CollectionUtils.printf(countries);
        */

        System.out.println("=====================");

        Set<String> colors = map(inventory, Apple::getColor) ;

        CollectionUtils.printf(colors);

        System.out.println("=========== getWeight ===========");

        Set<Double> a1 = map(inventory, Apple::getWeight) ;

        CollectionUtils.printf(a1);


        System.out.println("=====================");

        Set<Double> weight = map(inventory, new Function<Apple,Double>() {
            @Override
            public Double apply(Apple t) {
                return t.getWeight();
            }
        });

        CollectionUtils.printf(weight);

        System.out.println("=========== Solution ==========");

        Set<Double> weights = map(inventory,Apple :: getWeight);
        CollectionUtils.printf(weights);
        System.out.println("=====================");
        List<String> text = Arrays.asList("abc","abcde","ab","abcdefgh");

        Set<Integer> lengths = map(text, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length() ;
            }
        });
        CollectionUtils.printf(lengths);



    }

    /**
     * Get apples with given condition
     *
     * @para
     * @return
     */

    /**private static <R> Set<R> map(List<Apple> apples , Function<Apple,R> function){
            Set<R> result = new HashSet<>();

        for (Apple r : apples) {
            result.add(function.apply(r));
        }

        return result;

    }*/

    private static <T,R> Set<R> map(List<T> elements , Function<T,R> function){
        Set<R> result = new HashSet<>();

        for (T t : elements) {
            result.add(function.apply(t));
        }

        return result;

    }


    private static List<Apple> filterApple(List<Apple> inventory , Strategy<Apple> strategy){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (strategy.behavior(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
