package demo;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

import java.util.ArrayList;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        // Stream is "sequences of elements from SOURCE that helps manipulate collection of data "
        List<Dish> menu = DishUtils.getAll();

        List<Dish> meatDish = new ArrayList<>();
        for (Dish dish : menu){
            if (Kind.MEAT.equals(dish.getKind())){
                meatDish.add(dish);
            }
        }

        meatDish.forEach(System.out::println);
        System.out.println("======================");
        List<Dish> result = new ArrayList<>();
        for (Dish dish: meatDish){
            if (dish.getCalories() > 400){
                result.add(dish);
            }
        }
        result.forEach(System.out::println);
    }
}
