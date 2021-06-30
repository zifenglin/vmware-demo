package com.huafa.group;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: lhw
 * @date: 2021/6/24 下午4:22
 **/
public class OptionalTest {

    public static void main(String[] args) {
        String a = null;
        // String b = Optional.ofNullable(a).get();
        //   System.out.println(c);
        //      System.out.println(Optional.empty());
//
//        System.out.println(Optional.ofNullable(a).filter(e -> "a".equals(e)).orElse(null));

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //     System.out.println(Optional.ofNullable(list).filter(bean -> bean.isEmpty()).orElse(null));
//        Optional.ofNullable(list).filter(bean->bean.isEmpty()).orElse(new ArrayList<>());
//        Optional.ofNullable(list).filter(bean->!bean.isEmpty()).orElseGet(()->new ArrayList<>());

        //    Optional.ofNullable(list).filter(bean -> bean.get(1).equals("a")).get();
        //    System.out.println(Optional.ofNullable(a).orElseGet(() -> "aabb"));

        //     Optional.ofNullable(a).orElseThrow(()->new RuntimeException("aaa"));

        //  list = null;
        //   System.out.println(Optional.ofNullable(list).map(bean -> bean.size()).get());

        //      list = null;
//        Optional<List<String>> aa = Optional.ofNullable(list).filter(bean -> {
//            if (bean.isEmpty())
//                return false;
//            return true;
//        });
//
//        System.out.println(aa);
//
//        Optional<String> cc = aa.map(bean -> bean.get(1));
//        System.out.println(cc);
//
//        System.out.println(cc.orElse("dfdf"));
//
//        System.out.println(Optional.ofNullable(list).map(bean -> {
//            if (bean.get(1).equals("aa"))
//                return "aa";
//            return "bb";
//        }).orElse("cccc"));
//
//        Optional.ofNullable(list).map(bean -> {
//            if (bean.get(1).equals("aa"))
//                return "aa";
//            return null;
//        }).orElse("cccc");

        //   list = null;
//        List<String> bb = Optional.ofNullable(list).filter(bean -> {
//            if (bean.get(1).equals("1")) {
//                bean.remove(1);
//            }
//            return true;
//        }).orElse(new ArrayList<>());
//        System.out.println(bb);

        //list=new ArrayList<>();

        //         System.out.println(Optional.ofNullable(list).map(bean->bean.size()).orElse(0));


//        Optional<Integer> aa = Optional.ofNullable(list).flatMap(bean -> {
//            bean.remove(1);
//            return Optional.ofNullable(bean.size());
//        });
//        System.out.println(aa);
//        System.out.println(aa.orElse(0));
        //  System.out.println(list.size());
//
//        Optional.ofNullable(list).filter(bean -> {
//            bean.remove(1);
//            return true;
//        }).orElseGet(() -> {
//            List<String> aaa = new ArrayList<>();
//            return aaa;
//        });


//        System.out.println(aa);
//        System.out.println(aa.get().size());
//        System.out.println(list.size());
        //  list = null;
        //  System.out.println(Optional.ofNullable(list).isPresent());

//        list=null;
//        Optional.ofNullable(list).ifPresent(bean -> {
//            bean.remove(1);
//            System.out.println(bean.size());
//        });

        //   System.out.println(list);

//        System.out.println(Optional.ofNullable(list).filter(bean -> bean.isEmpty()));
//        List<String> aa = Optional.ofNullable(list).filter(bean -> !bean.isEmpty()).orElse(null);
//        System.out.println(aa);
        System.out.println(Optional.ofNullable(list).map(bean->bean.size()));
        list = null;
        Integer aa = Optional.ofNullable(list).map(bean -> bean.size()).orElse(0);
        System.out.println(aa);
    }
}
