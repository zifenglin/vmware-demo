package com.huafa.group;

/**
 * @author: lhw
 * @date: 2021/6/27 下午10:43
 **/
public class Plate<T> {

    private T t;

//    public Plate() {
//
//    }

    public Plate(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public Plate<T> setT(T t) {
        this.t = t;
        return this;
    }
}
