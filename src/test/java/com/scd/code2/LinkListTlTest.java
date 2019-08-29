package com.scd.code2;

import com.scd.code2.IList;
import com.scd.code2.link.LinkListTl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/27.
 */
public class LinkListTlTest {

    public IList<String> createIList(){
        IList<String> linkListTl = new LinkListTl();
        linkListTl.add("a");
        linkListTl.add("b");
        linkListTl.add("c");
        linkListTl.add("d");
        linkListTl.add("e");
        linkListTl.add("f");
        return linkListTl;
    }

    @Test
    public void testAdd(){
        LinkListTl linkListTl = new LinkListTl();
        linkListTl.add("1");
        linkListTl.add("2");
        linkListTl.add("3");
        Assert.assertEquals(3, linkListTl.size());
    }

    @Test
    public void testInsert(){
        IList<String> linkListTl = createIList();
        linkListTl.insert(0, "1");
        linkListTl.insert(3, "2");
        linkListTl.insert(linkListTl.size(), "3");
    }

    @Test
    public void testRemove(){
        IList<String> linkListTl = createIList();
        String e1 = linkListTl.remove(0);
        Assert.assertEquals(null, e1);
    }

    @Test
    public void testGet(){
        IList<String> linkListTl = createIList();
        String e1 = linkListTl.get(0);
        Assert.assertEquals(null, e1);
        String e2 = linkListTl.get(1);
        Assert.assertEquals("a", e2);
    }

    @Test
    public void testClear(){
        IList<String> linkListTl = createIList();
        linkListTl.clear();
    }
}
