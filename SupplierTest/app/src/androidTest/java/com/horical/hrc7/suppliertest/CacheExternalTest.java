package com.horical.hrc7.suppliertest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.horical.hrc7.supplier.app.AppManager;
import com.horical.hrc7.supplier.network_api.login.dto.UserDTO;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CacheExternalTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.horical.hrc7.suppliertest", appContext.getPackageName());
    }

    @Test
    public void testSaveData() {
        String test = "hello 1";

        AppManager.cache().external().save("test", "hello 1");
        String test1 = AppManager.cache().external().load("test", String.class);
        assertTrue(test.equals(test1));
        AppManager.cache().external().save("sdfsd",new UserDTO());

    }

    @Test
    public void testLoadData() {
        String test = "hello 1";
        String test1 = AppManager.cache().external().load("test", String.class);
        assertEquals(test, test1);
    }

    @Test
    public void testSaveArrayData() {
        String[] temps = new String[2];
        temps[0] = "hehe1";
        temps[1] = "hehe2";

        AppManager.cache().external().save("tests", temps);

        String[] temps1 = AppManager.cache().external().loadArray("tests", String.class);
        assertTrue(temps[0].equals(temps1[0]));
    }

    @Test
    public void testLoadArrayData() {
        String[] temps = new String[2];
        temps[0] = "hehe1";
        temps[1] = "hehe2";

        String[] temps1 = AppManager.cache().external().loadArray("tests", String.class);
        assertTrue(temps[0].equals(temps1[0]));
    }


}
