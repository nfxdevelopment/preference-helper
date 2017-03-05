package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import com.nfx.android.preferencehelper.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * NFX Development
 * Created by nick on 15/09/16.
 */
@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, constants = BuildConfig.class)
public class StringPreferenceTest {

    @SuppressWarnings("FieldCanBeLocal")
    private final String testKey = "test_key";
    private final String defaultValue = "DEFAULT_VALUE";
    private StringPreference stringPreference;

    @Before
    public void setUp() {
        // First set up the shared prefs
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (RuntimeEnvironment
                .application.getApplicationContext());
        stringPreference = new StringPreference(mSharedPreferences, testKey, defaultValue);
    }

    @Test
    public void testGet() throws Exception {
        assertThat("Should pass back the default value as nothing as been set",
                stringPreference.get(), is(defaultValue));

    }

    @Test
    public void testIsSet() throws Exception {
        assertThat("Should return false due to preference no being set",
                stringPreference.isSet(), is(false));
        stringPreference.set("TestIsSet");
        assertThat("Should return true as preference has just been set",
                stringPreference.isSet(), is(true));
    }

    @Test
    public void testSet() throws Exception {
        String testString = "TestSet";
        stringPreference.set(testString);
        assertThat("Should pass back the value just written", stringPreference.get(), is
                (testString));
    }

    @Test
    public void testDelete() throws Exception {
        stringPreference.set("TestDelete");
        assertThat("Should return true as preference has just been set",
                stringPreference.isSet(), is(true));
        stringPreference.delete();
        assertThat("Should return false as preference has just been deleted",
                stringPreference.isSet(), is(false));

    }
}