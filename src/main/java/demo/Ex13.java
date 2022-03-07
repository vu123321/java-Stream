package demo;

import bean.Dish;
import utils.DishUtils;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public class Ex13 {
    public static void main(String[] args) {
        List<Dish> menu = DishUtils.getAll();

        double sumOfCalories = menu.stream().
                map(Dish::getCalories)
                .reduce(0d,Double::sum);
        System.out.println("sumOfCalories:"+sumOfCalories);
        System.out.println("====================");
        // Primitive Stream : InStream, LongStream, DoubleStream
        double priSumOfCalories = menu.stream() // Stream<Dish>
                .mapToDouble(Dish::getCalories)
                .sum();
        System.out.println("priSumOfCalories: "+priSumOfCalories);

        // How could you find dish with maximum calories

        Optional<Dish> dishOpt =menu.stream()
                .reduce(Dish::maxClr);

        dishOpt.ifPresent(System.out::println);
    }

}
