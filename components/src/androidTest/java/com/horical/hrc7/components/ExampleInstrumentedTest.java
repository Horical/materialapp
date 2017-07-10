package com.horical.hrc7.components;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleInstrumentedTest {
    @Mock
    Context context;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.horical.hrc7.components.test", appContext.getPackageName());
    }

    @Test
    public void loginInvalidate() {
        LoginView loginView = new LoginView(context);
        Mockito.when(loginView.user_name.getText().toString()).thenReturn("hello");
        Mockito.when(loginView.password.getText().toString()).thenReturn("hello");
        assertTrue(loginView.isValid());
    }
}
