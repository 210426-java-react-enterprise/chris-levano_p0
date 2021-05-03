package com.revature.quizzard.util;

public interface List<T> {
    //T is the generic =>
        //generics is the implementation of parametric polymorphism
            //class will have a parameterized type
                // meaning => I do'nt know what type will be in this list, I'll let you know when I create it

    void add(T data);
    T pop();
//    T get(T index);
    boolean contains(T data);
    int size();


}
