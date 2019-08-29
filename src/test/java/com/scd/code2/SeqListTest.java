package com.scd.code2;

import com.scd.code2.IList;
import com.scd.code2.SeqList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/25.
 */
public class SeqListTest {


    @Test
    public void testSize(){
        IList<String> iList = new SeqList<>(5);
        iList.add("1");
        Assert.assertEquals(1, iList.size());
    }

    @Test
    public void testInsert(){
        IList<String> iList = new SeqList<>(5);
        iList.add("1");
        iList.add("2");
        iList.add("3");
        iList.add("4");
        iList.insert(4, "0");
        System.out.println(iList);
    }

    @Test
    public void testRemove(){
        IList<String> iList = new SeqList<>(5);
        iList.add("0");
        iList.add("1");
        iList.add("2");
        iList.add("3");
        iList.add("4");
        iList.get(4);
        Assert.assertEquals("3",iList.remove(3));
        Assert.assertEquals(4, iList.size());
    }

    @Test
    public void testGet(){
        IList<String> iList = new SeqList<>(5);
        iList.add("0");
        iList.add("1");
        iList.add("2");
        Assert.assertEquals("1", iList.get(1));
    }

    @Test
    public void testIndexOf(){
        IList<String> iList = new SeqList<>(5);
        iList.add("1");
        iList.add("1");
        iList.add("1");
        Assert.assertEquals(0, iList.indexOf("1"));
        Assert.assertEquals(-1, iList.indexOf("3"));
    }

    @Test
    public void testClearIsEmpty(){
        IList<String> iList = new SeqList<>(5);
        Assert.assertEquals(true, iList.isEmpty());
        iList.add("1");
        iList.add("1");
        iList.add("1");
        iList.display();
        Assert.assertEquals(false, iList.isEmpty());
        iList.clear();
        Assert.assertEquals(true, iList.isEmpty());
    }
}
