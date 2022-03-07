package functional;

import bean.Apple;

@FunctionalInterface
public interface BuFunction<T, R, S, M, N> {
    T get(R r, S s, M m, N n) ;
}