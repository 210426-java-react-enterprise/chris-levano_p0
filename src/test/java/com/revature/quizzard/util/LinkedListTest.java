package com.revature.quizzard.util;

<<<<<<< HEAD:src/test/java/com/revature/quizzard/util/LinkedListTest.java
import sun.awt.image.ImageWatched;

//unit testing is the idea of testing a single unit of code
//most granular individual piece of code to test is a method
=======
import com.revature.quizzard.screens.Screen;
>>>>>>> 85905ac93f677d192de3fa04dbe7dba20cab23ff:test/com/revature/quizzard/util/LinkedListTest.java

public class LinkedListTest {

    //sut => system under test
    private LinkedList<String> sut;
    private LinkedList<? extends Screen> ex1; // generics with subtyping
    private LinkedList<?> ex2; // the ? denotes wildcard

    public void test_add_withNull() {

        // Arrange test
        sut = new LinkedList<>();

        // Act (perform the action to be tested)
        try {
            sut.add(null);
            System.out.println("Test: test_add_withNull did not pass!");
        } catch (IllegalArgumentException e) {
            // Assert
            System.out.println("Test: test_add_withNull passed!");

        }

    }

//    public void test_add_wi

    public void test_add_withNonNullValue() {

        // Arrange (set up the test)
        sut = new LinkedList<>();
        // Act (do the test)
        sut.add("not null!!");

        // Assert (verify outcomes)
        if (sut.size() == 2) {
            System.out.println("Test: test_add_withNonNullValue passed!");
        } else {
            System.out.println("Test: test_add_withNonNullValue did not pass!");
        }

        if(sut.size() == 2){
            System.out.println("Test: test_add_withNonNullValue passed!");
        }
        else{
            System.out.println("Test: test_add_withNonNullValue failed.");
        }

    }
}
