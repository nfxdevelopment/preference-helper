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
public class IntegerPreferenceTest {

    @SuppressWarnings("FieldCanBeLocal")
    private final String testKey = "test_key";
    private final int defaultValue = (int) (Math.random() * Integer.MAX_VALUE);
    private IntegerPreference integerPreference;

    @Before
    public void setUp() {
        // First set up the shared prefs
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (RuntimeEnvironment
                .application.getApplicationContext());
        integerPreference = new IntegerPreference(mSharedPreferences, testKey, defaultValue);
    }

    @Test
    public void testGet() throws Exception {
        assertThat("Should pass back the default value as nothing as been set",
                integerPreference.get(), is(defaultValue));

    }

    @Test
    public void testIsSet() throws Exception {
        assertThat("Should return false due to preference no being set",
                integerPreference.isSet(), is(false));
        integerPreference.set(0);
        assertThat("Should return true as preference has just been set",
                integerPreference.isSet(), is(true));
    }

    @Test
    public void testSet() throws Exception {
        int randomNumber = (int) (Math.random() * Integer.MAX_VALUE);
        integerPreference.set(randomNumber);
        assertThat("Should pass back the value just written", integerPreference.get(), is
                (randomNumber));
    }

    @Test
    public void testDelete() throws Exception {
        integerPreference.set(0);
        assertThat("Should return true as preference has just been set",
                integerPreference.isSet(), is(true));
        integerPreference.delete();
        assertThat("Should return false as preference has just been deleted",
                integerPreference.isSet(), is(false));

    }
}