package com.scd.code1;

import com.scd.code2.IList;
import com.scd.code2.link.LinkList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/26.
 */
public class LinkListTest {

    @Test
    public void testLinkList(){
        LinkList<String> linkList = new LinkList();
        linkList.add("1");
        linkList.add("2");
        linkList.add("3");
        linkList.display();
        String e1 = linkList.get(0);
        String e2 = linkList.get(1);
        String e3 = linkList.get(2);
        String e4 = linkList.get(3);
        System.out.println(e1);
    }

    private IList<String> createList(){
        IList<String> linkList = new LinkList();
        linkList.add("a");
        linkList.add("b");
        linkList.add("c");
        linkList.add("d");
        linkList.add("e");
        return linkList;
    }

    @Test
    public void testGet(){
        IList<String> linkList = createList();
        String e1 = linkList.get(0);
        Assert.assertEquals("c", e1);
        String e2 = linkList.get(1);
        Assert.assertEquals("b", e2);
        String e3 = linkList.get(2);
        Assert.assertEquals("a", e3);
        try {
            String e4 = linkList.get(3);
            Assert.fail("get bug-----");
        } catch (Exception e){
            Assert.assertEquals("index 3 out of size", e.getMessage());
        }
    }

    @Test
    public void testSize(){
        IList<String> linkList = createList();
        Assert.assertEquals(3, linkList.size());
    }

    @Test
    public void testInsert(){
        IList<String> linkList = createList();
        linkList.insert(0, "1");
        linkList.insert(2, "2");
        try {
            linkList.insert(linkList.size(), "3");
            Assert.fail("bug----------");
        } catch (Exception e){
            Assert.assertEquals("index " + linkList.size() + " out of size", e.getMessage());
        }
    }

    @Test
    public void testRemove(){
        IList<String> linkList = createList();
        String r = linkList.remove(0);
        Assert.assertEquals("e", r);
        String r1 = linkList.remove(2);
        Assert.assertEquals("b", r1);
    }

    @Test
    public void testIndexOf(){
        IList<String> linkList = createList();
        Assert.assertEquals(0, linkList.indexOf("e"));
        Assert.assertEquals(4, linkList.indexOf("a"));
    }
}
