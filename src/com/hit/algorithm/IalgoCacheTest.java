package com.hit.algorithm;


import org.junit.Assert;
import org.junit.Test;

public class IalgoCacheTest {
    public IalgoCacheTest() {
    }

    @Test
    public void LRUAlgoCacheTest() {
        Integer capacity = 3;
        LRUAlgoCacheImpl<Integer, String> test = new LRUAlgoCacheImpl(capacity);
        System.out.println("\n ############################ \n      LRU Algo Cache Test \n ############################ \n");
        String returnValue = (String)test.putElement(2, "value: 2");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(4, "value: 4");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(2, "value: 2");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 2", returnValue);
        returnValue = (String)test.putElement(1, "value: 1");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 3", returnValue);
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 4", returnValue);
        returnValue = (String)test.putElement(7, "value: 7");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 2", returnValue);
        returnValue = (String)test.putElement(5, "value: 5");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 1", returnValue);
        returnValue = (String)test.putElement(4, "value: 4");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 3", returnValue);
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 7", returnValue);
    }

    @Test
    public void MRUAlgoCacheTest() {
        Integer capacity = 3;
        MRUAlgoCacheImpl<Integer, String> test = new MRUAlgoCacheImpl(capacity);
        System.out.println("\n ############################ \n      MRU Algo Cache Test \n ############################ \n");
        String returnValue = (String)test.putElement(7, "value: 7");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(0, "value: 0");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(1, "value: 1");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals((Object)null, returnValue);
        returnValue = (String)test.putElement(2, "value: 2");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 1", returnValue);
        returnValue = (String)test.putElement(0, "value: 0");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 0", returnValue);
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 0", returnValue);
        returnValue = (String)test.putElement(0, "value: 0");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 3", returnValue);
        returnValue = (String)test.putElement(4, "value: 4");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 0", returnValue);
        returnValue = (String)test.putElement(2, "value: 2");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 2", returnValue);
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        Assert.assertEquals("value: 2", returnValue);
    }

    @Test
    public void RandomTest() {
        Integer capacity = 3;
        RandomAlgoCacheImpl<Integer, String> test = new RandomAlgoCacheImpl(capacity);
        System.out.println("\n ############################ \n         Random Test \n ############################ \n");
        String returnValue = (String)test.putElement(5, "value: 5");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(8, "value: 8");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(10, "value: 10");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(5, "value: 5");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(0, "value: 0");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(0, "value: 0");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(4, "value: 4");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(2, "value: 2");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(5, "value: 5");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(4, "value: 4");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
        returnValue = (String)test.putElement(3, "value: 3");
        System.out.println("elemntToReturn: " + returnValue + "\n ---------------- \n");
    }
}
