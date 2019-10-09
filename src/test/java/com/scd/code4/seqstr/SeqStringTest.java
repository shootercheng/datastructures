package com.scd.code4.seqstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author James Chen
 * @date 08/10/19
 */
public class SeqStringTest {

    @Test
    public void testCpChar() {
        String astr = "A";
        String alstr = "a";
        System.out.println(astr.compareTo(alstr));
    }

    @Test
    public void testIndex() {
        String name = "Java";
        Assert.assertEquals(1, name.indexOf("a"));
    }

    @Test
    public void testCharAt() {
        IString iString = new SeqString("James");
        Assert.assertEquals("J", String.valueOf(iString.charAt(0)));
        Assert.assertEquals("m", String.valueOf(iString.charAt(2)));
    }

    @Test
    public void testSub() {
        String teststr = "Hello Java!";
        Assert.assertEquals("Hello", teststr.substring(0, 5));
        IString iString = new SeqString(teststr);
        Assert.assertEquals("Hello", new String(iString.substring(0, 5).getCharArr()));
    }

    @Test
    public void testInsert() {
        String teststr = "Hello Java!";
        String insertstr = " James";
        IString iString = new SeqString(teststr);
        IString insertStr = new SeqString(insertstr);
        IString resultStr = iString.insert(5, insertStr);
        Assert.assertEquals("Hello James Java!", new String(resultStr.getCharArr()));
    }

    @Test
    public void testDelete() {
        String teststr = "Hello Java!";
        IString iString = new SeqString(teststr);
        Assert.assertEquals(" Java!", new String(iString.delete(0, 5).getCharArr()));
    }

    @Test
    public void testConcat() {
        String str1 = "Hello ";
        IString istr1 = new SeqString(str1);
        String str2 = "Java!";
        IString istr2 = new SeqString(str2);
        Assert.assertEquals("Hello Java!", new String(istr1.concat(istr2).getCharArr()));
    }

    @Test
    public void testCompare() {
        IString str1 = new SeqString("A");
        IString str2 = new SeqString("a");
        Assert.assertTrue(str1.compareTo(str2) < 0);
        IString stra = new SeqString("Java");
        IString strb = new SeqString("James");
        Assert.assertTrue(stra.compareTo(strb) > 0);
    }

    @Test
    public void testIndexOf() {
        IString istr1 = new SeqString("Java!");
        Assert.assertEquals(1, istr1.indexOf("a", 0));
        Assert.assertEquals(11, "JamesJacdsdJavaccdd".indexOf("Java"));
        IString istr2 = new SeqString("JamesJacdsdJavaccdd");
        Assert.assertEquals(11, istr2.indexOf("Java", 0));
    }
}
