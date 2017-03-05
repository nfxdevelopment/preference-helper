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
public class LongPreferenceTest {

    @SuppressWarnings("WeakerAccess")
    final String testKey = "test_key";
    private final long defaultValue = (long) (Math.random() * Long.MAX_VALUE);
    private LongPreference longPreference;

    @Before
    public void setUp() {
        // First set up the shared prefs
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (RuntimeEnvironment
                .application.getApplicationContext());
        longPreference = new LongPreference(mSharedPreferences, testKey, defaultValue);
    }

    @Test
    public void testGet() throws Exception {
        assertThat("Should pass back the default value as nothing as been set",
                longPreference.get(), is(defaultValue));

    }

    @Test
    public void testIsSet() throws Exception {
        assertThat("Should return false due to preference no being set",
                longPreference.isSet(), is(false));
        longPreference.set((long) 0);
        assertThat("Should return true as preference has just been set",
                longPreference.isSet(), is(true));
    }

    @Test
    public void testSet() throws Exception {
        long randomNumber = (long) (Math.random() * Long.MAX_VALUE);
        longPreference.set(randomNumber);
        assertThat("Should pass back the value just written", longPreference.get(), is
                (randomNumber));
    }

    @Test
    public void testDelete() throws Exception {
        longPreference.set((long) 0);
        assertThat("Should return true as preference has just been set",
                longPreference.isSet(), is(true));
        longPreference.delete();
        assertThat("Should return false as preference has just been deleted",
                longPreference.isSet(), is(false));

    }
}