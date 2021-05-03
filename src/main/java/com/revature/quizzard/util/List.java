package com.revature.quizzard.util;

public interface List<T> {
<<<<<<< HEAD
    //T is the generic =>
        //generics is the implementation of parametric polymorphism
            //class will have a parameterized type
                // meaning => I do'nt know what type will be in this list, I'll let you know when I create it

    void add(T data);
    T pop();
//    T get(T index);
    boolean contains(T data);
    int size();

=======

    // interfaces do not have constructors!

    // all fields declared within interfaces are implicitly
    // public, static, and final

    // all method stubs declared within interfaces are implicitly
    // public and abstract
    void add(T data);
    T pop();
    T get(int index);
    boolean contains(T data);
    int size();

    // interfaces can have methods with implementations
    // in the form of either static or default methods

    // static methods cannot be overridden (but you can shadow it)
    static void staticMethod() {
        System.out.println("This is a static method declared within an interface");
    }

    // since Java 8 you can declare default methods
    // which provide a, well, default implementation
    // but can be overridden by lower level classes
    default void defaultMethod() {
        System.out.println("This is a default method, it can be overridden!");
    }

>>>>>>> 85905ac93f677d192de3fa04dbe7dba20cab23ff

}
