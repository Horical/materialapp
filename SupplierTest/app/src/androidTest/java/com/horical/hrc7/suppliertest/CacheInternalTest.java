package com.horical.hrc7.suppliertest;

import android.support.test.runner.AndroidJUnit4;

import com.horical.hrc7.supplier.app.AppManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by HRC7 on 7/5/2017.
 */

@RunWith(AndroidJUnit4.class)
public class CacheInternalTest {
    @Test
    public void testShareSaveString() {
        String test = "hello 1";

        AppManager.cache().internal().save("test", "hello 1");
        String test1 = AppManager.cache().internal().load("test", "");
        assertTrue(test.equals(test1));
    }

    @Test
    public void testShareLoadString() {
        String test = "hello 1";

        String test1 = AppManager.cache().internal().load("test", "");
        assertTrue(test.equals(test1));
    }

    @Test
    public void testShareSaveInteger() {
        int test = 1;

        AppManager.cache().internal().save("testInteger", 1);
        int test1 = AppManager.cache().internal().load("testInteger", -1);
        assertTrue(test == test1);
    }

    @Test
    public void testShareLoadInteger() {
        int test = 1;

        int test1 = AppManager.cache().internal().load("testInteger", -1);
        assertTrue(test == test1);
    }

    @Test
    public void testShareLoadIntegerFail() {
        int test = 1;

        String test1 = AppManager.cache().internal().load("testInteger", "String");
        //assertTrue(test == test1);
        fail(test1);
    }
}
