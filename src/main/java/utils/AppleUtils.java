package utils;

import bean.Apple;

import java.util.Arrays;
import java.util.List;

public class AppleUtils {
    public AppleUtils() {
    }

    public static List<Apple> getAll(){
        return Arrays.asList(new Apple(1,"green",200,"VietNam"),
                new Apple(2,"green",290,"VietNam"),
                new Apple(16,"red",300,"VietNam"),
                new Apple(4,"yellow",400,"ThaiLan"),
                new Apple(17,"green",280,"Lao"),
                new Apple(1,"green",200,"VietNam"),
                new Apple(20,"red",320,"ThaiLan"),
                new Apple(18,"green",330,"VietNam"));
    }
}
