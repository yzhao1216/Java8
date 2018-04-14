package com.java8.Lambda;

/**
 * Created by yizhao on 4/2/2018.
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
