package com.huafa.group;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: lhw
 * @date: 2021/6/27 下午2:41
 **/
public class FanXingTest {

    public static void main(String[] args) {
//        List<? extends Fruit> list1 = new ArrayList<>();
//        // list1.add(new Fruit());
//
//        List<? super Fruit> list2 = new ArrayList<>();
//        list2.add(new Fruit());
//
//        Plate<? extends Fruit> plate = new Plate<>(new Apple());
//        Fruit a = plate.getT();
//
//
//        Plate<? super Fruit> p2 = new Plate<>(new Foo());
//        p2.setT(new Fruit());
//        //   p2.setT(new Foo());
//        p2.setT(new Apple());
//
//        Object aa = p2.getT();

//        Plate<Fruit> plate = new Plate<>(new Fruit());
//        plate.setT(new Apple());
//        plate.getT();

//        Plate<? extends Fruit> plate = new Plate<>();
//        Fruit a = plate.getT();
//
//        Plate<? extends Fruit> plate = new Plate<>(new Fruit());
//
//        System.out.println(plate.getT().getClass());

        //       List<? extends Fruit> list1= new ArrayList<>();

//        Plate<? super Fruit> plate = new Plate<>();
//        plate.setT(new Apple());

        //       Plate<? extends Fruit> plate = new Plate<>(new Apple());

//        Plate<Fruit> plate = new Plate<>(new Apple());

        //    Plate<?> plate = new Plate<>(new Fruit());
        //  plate.setT(new Fruit());

        //     List<? extends Number> list = new ArrayList<>();

//        List<Apple> list = new ArrayList<>();
//        test(list);
//
//        List<String> aa = new ArrayList<>();
//        test1(aa);


//        Plate<? extends Fruit> plate = new Plate<>(new Fruit());
//        Fruit aa = plate.getT();

        Plate<? super Fruit> plate = new Plate<>(new Fruit());
        plate.setT(new Apple());
        Object obj = plate.getT();

        System.out.println(obj.getClass().getName());

    }

    public static void test2(Plate<? extends Fruit> aa) {

    }

    public static void test(Collection<? extends Fruit> a) {

    }

    public static void test1(List<?> b) {

    }

}

class Foo {

}

class Meat extends Foo {

}

class Park extends Meat {

}

class Beef extends Meat {

}

class Fruit extends Foo {

}

class Apple extends Fruit {

}

class RedApple extends Apple {

}

class GreenApple extends Apple {

}


