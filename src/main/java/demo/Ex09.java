package demo;

import bean.Dish;
import utils.CollectionUtils;
import utils.DishUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex09 {

    /**
     * select unique dish's calories from menu
     * @param args
     */
    public static void main(String[] args) {


        List<Dish> menu = DishUtils.getAll();

        // How to do 1

        menu.stream()
                .filter(dish -> Collections.frequency(menu,dish) == 1) // Stream<Integer>
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("====== uniqueBy ======");

        List<Dish> data = uniqueBy(menu,Dish::getCalories);
        CollectionUtils.printf(data);

        System.out.println("====== distinctBy ======");

        List<Dish> list = distinctBy(menu,Dish::getCalories);
        CollectionUtils.printf(list);


        /**
        // uniqueBy - How to do 1

          menu.stream()
                .filter(dish -> Collections.frequency(menu,dish) == 1) // Stream<Integer>
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("==============");


        //uniqueBy -  How to do 2
      Map<Double,List<Dish>> dishes = menu.stream()
               .collect(Collectors.groupingBy(Dish::getCalories));

      List<Dish>data =  dishes.values()
              .stream()
              .filter(dishList -> dishList.size() == 1)
              .map(dishList -> {
                  return dishList.get(0);
              })
              .collect(Collectors.toList());
        CollectionUtils.printf(data);
         */
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9,2,3);
        List<List<Integer>> list4 = Arrays.asList(list1,list2,list3);

        System.out.println("=================");
         list4.stream()
                .flatMap(Collection::stream)
                 .filter(i -> i % 2 != 0)
                 .sorted()
                .forEach(System.out::println);






    }

    //uniqueBy -  How to do 3

   private static <T,R> List<T> uniqueBy(List<T> list,Function<T,R> func){

        Map<R,List<T>> map = list.stream()
                .collect(Collectors.groupingBy(func));

        return map.values()
                .stream()
                .filter(d -> d.size() == 1)
                .map(d ->d.get(0))
                .collect(Collectors.toList());
   }
    private static <T,R> List<T> distinctBy(Collection<T> list, Function<T,R> func){

        Set<T> storage = new HashSet<>();
        return list.stream()
                .filter(s -> storage.add((T) func.apply(s)))
                .collect(Collectors.toList());

    }
}
