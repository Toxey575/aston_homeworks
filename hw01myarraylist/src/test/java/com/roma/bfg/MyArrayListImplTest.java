package com.roma.bfg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MyArrayListImplTest {

    private MyArrayListImpl<Object> myObjectArrayList;

    @BeforeEach()
    void create() {

        myObjectArrayList = new MyArrayListImpl<>();

    }

    @Test
    void getMethodPositiveTest() {

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            myObjectArrayList.add(i);
        }

        Assertions.assertEquals(0, myObjectArrayList.get(0));
        Assertions.assertEquals(5, myObjectArrayList.get(5));
        Assertions.assertEquals(9, myObjectArrayList.get(9));

    }

    @Test
    void addWithoutIndexInTailMethodPositiveTest() {

        int testInteger = 1;

        int oldSize = myObjectArrayList.size();

        myObjectArrayList.add(testInteger);
        Assertions.assertEquals(oldSize + 1, myObjectArrayList.size());
        Assertions.assertEquals(testInteger, myObjectArrayList.get(0));
    }

    @Test
    void addWithIndexInHeadMethodPositiveTest() {

        int testInteger = 1;

        int randomTestInteger;

        for (int i = 0; i < 10; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        int oldSize = myObjectArrayList.size();

        Object lastElement = myObjectArrayList.get((myObjectArrayList.size() - 1));

        myObjectArrayList.add(0, testInteger);
        Assertions.assertEquals(oldSize + 1, myObjectArrayList.size());
        Assertions.assertEquals(testInteger, myObjectArrayList.get(0));
        Assertions.assertEquals(lastElement, myObjectArrayList.get((myObjectArrayList.size() - 1)));
    }

    @Test
    void addWithIndexInTailMethodPositiveTest() {

        int testInteger = 1;

        int randomTestInteger;

        for (int i = 0; i < 10; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        int oldSize = myObjectArrayList.size();

        myObjectArrayList.add(myObjectArrayList.size() - 1, testInteger);

        Object lastElement = myObjectArrayList.get((myObjectArrayList.size() - 1));

        Assertions.assertEquals(oldSize + 1, myObjectArrayList.size());
        Assertions.assertEquals(testInteger, myObjectArrayList.get(myObjectArrayList.size() - 2));
        Assertions.assertEquals(lastElement, myObjectArrayList.get((myObjectArrayList.size() - 1)));
    }

    @Test
    void addAllInTailMethodPositiveTest() {

        int randomTestInteger;

        int numberOfElements = 10;

        MyArrayListImpl<Object> secondMyObjectArrayList = new MyArrayListImpl<>();

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        int oldSize = myObjectArrayList.size();

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            secondMyObjectArrayList.add(randomTestInteger);
        }

        int randomIndex = (int) (Math.random() * oldSize);

        MyArrayListImpl<Object> oldMyObjectArrayList = myObjectArrayList;

        myObjectArrayList.addAll(secondMyObjectArrayList);

        Assertions.assertEquals(oldSize + secondMyObjectArrayList.size(), myObjectArrayList.size());
        Assertions.assertEquals(oldMyObjectArrayList.get(randomIndex), myObjectArrayList.get(randomIndex));
        Assertions.assertEquals(secondMyObjectArrayList.get(randomIndex), myObjectArrayList.get(randomIndex + secondMyObjectArrayList.size()));
        Assertions.assertEquals(secondMyObjectArrayList.get(secondMyObjectArrayList.size() - 1), myObjectArrayList.get(myObjectArrayList.size() - 1));

    }

    @Test
    void clearMethodPositiveTest() {

        int randomTestInteger;

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        myObjectArrayList.clear();

        Assertions.assertNull(myObjectArrayList.get(0));
        Assertions.assertEquals(0, myObjectArrayList.size());

    }

    @Test
    void setMethodPositiveTest() {

        int testInteger = 1;

        int numberOfElements = 10;

        int randomTestInteger;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        myObjectArrayList.set(0, testInteger);

        Assertions.assertEquals(testInteger, myObjectArrayList.get(0));

        myObjectArrayList.set(myObjectArrayList.size() - 1, testInteger);

        Assertions.assertEquals(testInteger, myObjectArrayList.get(myObjectArrayList.size() - 1));

    }

    @Test
    void setMethodNegativeTest() {
        int testInteger = 1;

        int numberOfElements = 10;

        int randomTestInteger;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        Assertions.assertNull(myObjectArrayList.set(-1, testInteger));
        Assertions.assertNull(myObjectArrayList.set(myObjectArrayList.size(), testInteger));

    }

    @Test
    void indexOfMethodPositiveTest() {

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            myObjectArrayList.add(i);
        }

        Assertions.assertEquals(1, myObjectArrayList.indexOf(1));
        Assertions.assertEquals(5, myObjectArrayList.indexOf(5));
        Assertions.assertEquals(9, myObjectArrayList.indexOf(9));

    }

    @Test
    void removeByIndexMethodPositiveTest() {
        int numberOfElements = 10;

        int randomTestInteger;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        int oldSize = myObjectArrayList.size();

        Assertions.assertEquals(myObjectArrayList.get(0), myObjectArrayList.remove(0));
        Assertions.assertEquals(myObjectArrayList.size(), oldSize - 1);
        Assertions.assertEquals(myObjectArrayList.get(myObjectArrayList.size() - 1), myObjectArrayList.remove(myObjectArrayList.size() - 1));

    }

    @Test
    void removeByIndexMethodNegativeTest() {
        int numberOfElements = 10;

        int randomTestInteger;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        Assertions.assertNull(myObjectArrayList.remove(-1));
        Assertions.assertNull(myObjectArrayList.remove(myObjectArrayList.size()));

    }

    @Test
    void removeByElementMethodPositiveTest() {
        MyArrayListImpl<String> myStringArrayList = new MyArrayListImpl<>();

        myStringArrayList.add("abc");
        myStringArrayList.add("def");
        myStringArrayList.add("ghi");
        myStringArrayList.add("jkl");
        myStringArrayList.add("mno");

        int oldSize = myStringArrayList.size();

        Assertions.assertEquals(myStringArrayList.get(0), myStringArrayList.remove("abc"));
        Assertions.assertEquals(myStringArrayList.get(0), "def");
        Assertions.assertEquals(myStringArrayList.size(), oldSize - 1);
    }

    @Test
    void removeByElementMethodNegativeTest() {
        int numberOfElements = 10;

        int randomTestInteger;

        for (int i = 0; i < numberOfElements; i++) {
            randomTestInteger = (int) (1 + Math.random() * 100);
            myObjectArrayList.add(randomTestInteger);
        }

        Assertions.assertNull(myObjectArrayList.remove("xyz"));
    }

}