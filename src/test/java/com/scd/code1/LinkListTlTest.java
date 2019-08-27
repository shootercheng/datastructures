package com.scd.code1;

import com.scd.code2.link.LinkListTl;
import org.junit.Test;

/**
 * @author chengdu
 * @date 2019/8/27.
 */
public class LinkListTlTest {

    @Test
    public void testAdd(){
        LinkListTl linkListTl = new LinkListTl();
        linkListTl.add("1");
        linkListTl.add("2");
        linkListTl.add("3");
    }
}
