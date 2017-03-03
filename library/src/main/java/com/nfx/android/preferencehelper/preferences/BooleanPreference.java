package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * NFX Development
 * Created by nick on 19/09/16.
 * <p/>
 * A wrapper around a boolean preference for ease of access
 */
@SuppressWarnings("WeakerAccess")
public class BooleanPreference extends AbstractPreference<Boolean> {
    /**
     * @param preferences  where to save the preference
     * @param key          key to the preference
     * @param defaultValue default value for the preference
     */
    public BooleanPreference(@NonNull SharedPreferences preferences, @NonNull String key, Boolean
            defaultValue) {
        super(preferences, key, defaultValue);
    }

    public Boolean get() {
        return preferences.getBoolean(key, defaultValue);
    }

    public void set(Boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
}