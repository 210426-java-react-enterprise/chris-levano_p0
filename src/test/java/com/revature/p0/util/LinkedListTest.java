package com.revature.p0.util;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    private LinkedList<String> sut;

    @Before
    public void setUpTest() {
        sut = new LinkedList<>();
    }

    @After
    public void tearDownTest() {
        sut = null;
    }

    @Test
    public void test_addWithNonNullValue() {
        // Arrange (prepare the test)
        int expectedSize = 1;

        // Act (do the test)
        sut.add("data");

        // Assert (ensure the results)
        int actualSize = sut.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test(expected = Exception.class)
    public void test_addWithNullValue() {
        // Arrange
        // sometimes blank if there's nothing in particular to do

        // Act
        sut.add(null);

        // Assert
        // sometimes blank, especially if you expect an exception to be thrown
    }

    @Test
    public void test_pollWithEmptyList() {
        // Arrange
        // nothing to do here...

        // Act
        String actualResult = sut.poll();

        // Assert
        Assert.assertNull(actualResult);
    }

    @Test
    public void test_pollWithPopulatedList() {
        // Arrange
        sut.add("test data 1");
        sut.add("test data 2");
        String expectedResult = "test data 1";
        int expectedSize = 1;

        // Act
        String actualResult = sut.poll();

        // Assert
        int actualSize = sut.size();
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void test_peekWithEmptyList() {
        // Arrange
        // nothing to do here...

        // Act
        String actualResult = sut.peek();

        // Assert
        Assert.assertNull(actualResult);
    }

    @Test
    public void test_peekWithPopulatedList() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");
        String expectedResult = "test data 1";
        int expectedSize = 2;

        // Act
        String actualResult = sut.peek();

        // Assert
        int actualSize = sut.size();
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void test_getWithPopulatedList() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");
        String expectedResult = "test data 2";

        // Act
        String actualResult = sut.get(1);

        // Assert
        int actualSize = sut.size();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void test_getWithUnpopulatedList() {
        //Arrange
        String expectedResult = null;

        // Act
        String actualResult = sut.get(0);

        // Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getWithOutOfBoundsIndex() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");

        try {
            sut.get(4);
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void test_removeWithEmptyList() {
        //Arrange

        try {
            sut.remove("test");
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void test_removeWithPopulatedList() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");
        int expectedSize = 1;
        // Act
        sut.remove("test data 2");
        boolean actualResult = sut.contains("test data 2");
        int actualSize = sut.size();
        // Assert
        Assert.assertEquals(false, actualResult);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void test_containsWithEmptyList() {
        // Arrange
        // nothing to do here...

        // Act
        boolean actualResult = sut.contains("");

        // Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_containsWithPopulatedList() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");

        // Act
        boolean actualResult = sut.contains("test data 2");

        // Assert
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void test_containsWithPopulatedListButNoValue() {
        //Arrange
        sut.add("test data 1");
        sut.add("test data 2");
        boolean expectedResult = true;

        // Act
        boolean actualResult = sut.contains("test data 3");

        // Assert
        Assert.assertEquals(false, actualResult);
    }



}
