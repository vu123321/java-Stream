package demo;

import bean.AbsTractClass;
import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class AbstractClass {
    public static void main(String[] args) {
        List<Apple > inventory = AppleUtils.getAll();


        System.out.println("================================");
        List<Apple> result = filterApples(inventory, new AbsTractClass() {
            @Override
            public boolean behavior(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        CollectionUtils.printf(result);
        System.out.println("================================");
        List<Apple> red = filterApples(inventory, new AbsTractClass() {

            @Override
            public boolean behavior(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        CollectionUtils.printf(red);
        System.out.println("================================");




    }

    private     static  List<Apple> filterApples(List<Apple> inventory, AbsTractClass strategy){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (strategy.behavior(apple)){
                result.add(apple);
            }
        }

        return result;
    }
}
