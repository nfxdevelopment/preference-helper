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
public class BooleanPreferenceTest {

    @SuppressWarnings("FieldCanBeLocal")
    private final String testKey = "test_key";
    private final Boolean defaultValue = false;
    private BooleanPreference booleanPreference;

    @Before
    public void setUp() {
        // First set up the shared prefs
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (RuntimeEnvironment
                .application.getApplicationContext());
        booleanPreference = new BooleanPreference(mSharedPreferences, testKey, defaultValue);
    }

    @Test
    public void testGet() throws Exception {
        assertThat("Should pass back the default value as nothing as been set",
                booleanPreference.get(), is(defaultValue));

    }

    @Test
    public void testIsSet() throws Exception {
        assertThat("Should return false due to preference no being set",
                booleanPreference.isSet(), is(false));
        booleanPreference.set(true);
        assertThat("Should return true as preference has just been set",
                booleanPreference.isSet(), is(true));
    }

    @Test
    public void testSet() throws Exception {
        booleanPreference.set(true);
        assertThat("Should pass back the value just written", booleanPreference.get(), is(true));
        booleanPreference.set(false);
        assertThat("Should pass back the value just written", booleanPreference.get(), is(false));
    }

    @Test
    public void testDelete() throws Exception {
        booleanPreference.set(true);
        assertThat("Should return true as preference has just been set",
                booleanPreference.isSet(), is(true));
        booleanPreference.delete();
        assertThat("Should return false as preference has just been deleted",
                booleanPreference.isSet(), is(false));

    }
}