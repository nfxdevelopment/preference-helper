package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * NFX Development
 * Created by nick on 19/09/16.
 * <p/>
 * A wrapper around a integer preference for ease of access
 */
@SuppressWarnings("WeakerAccess")
public class IntegerPreference extends AbstractPreference<Integer> {
    /**
     * @param preferences  where to save the preference
     * @param key          key to the preference
     * @param defaultValue default value for the preference
     */
    public IntegerPreference(@NonNull SharedPreferences preferences, @NonNull String key, Integer
            defaultValue) {
        super(preferences, key, defaultValue);
    }

    public Integer get() {
        return preferences.getInt(key, defaultValue);
    }

    public void set(Integer value) {
        preferences.edit().putInt(key, value).apply();
    }
}