package com.java8.Lambda;

import com.sun.javafx.logging.PulseLogger;
import org.junit.Test;

import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Consumer;

/**
 * Created by yizhao on 4/2/2018.
 * 一，Lambda 表达式的基础语法，java8 应入新的操作符 “->”, 箭头操作符货 Lambda操作符
 * -> 将Lambda表达式拆分为两部分。
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需要执行的功能，lambda体
 *
 * 语法格式1：无参数，无返回值
 *          () -> System.out.println("Hello Lambda")
 * 语法格式2：有一个参数，无返回值
 *          (x) -> System.out.println("ddfasdfd")
 * 语法格式3：
 * 语法格式4：有两个以上参数，有返回值，lambda中有多条语句
 *          Comparator<Integer> con = (x,y) -> {
            System.out.println("method interface");
            return Integer.compare(x,y);
            };
 * 语法格式5：若Lambda体中只有一条语句，{} 和 return可以省略
 *          Comparator<Integer> com = (x,y) -> Integer.compare(x,y)
 * 语法格式6：Lambda表达式参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出数据类型
 *          即“类型推断”
 *          (Integer x, Integer y) -> Integer.compare(x,y)
 *
 *二，lambda表达式需要“method interface”支持
 *      借口中只有一个抽象方法的借口，成为函数式借口，可以用@FunctionalInterface
 *      可以检查接口是不是函数式接口
 *
 */
public class TestLambda2 {
    @Test
    public void test1(){
        Runnable r = () -> System.out.println("Hello world");
        r.run();
        System.out.println("------------");

        Runnable r1 = () -> System.out.println("Hello lambda");

        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("dadada");

    }

    @Test
    public void test3(){
        Comparator<Integer> con = (x,y) -> {
            System.out.println("method interface");
            return Integer.compare(x,y);
        };
    }

    //对一个数进行运算
    @Test
    public void test4(){
        int num = operation(100,(x)->x * x);
        System.out.println(num);

        System.out.println(operation(200,y->y+200));
    }
    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}
