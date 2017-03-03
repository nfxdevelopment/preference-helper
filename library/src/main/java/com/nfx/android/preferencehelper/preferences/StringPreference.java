package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * NFX Development
 * Created by nick on 19/09/16.
 * <p/>
 * A wrapper around a string preference for ease of access
 */
@SuppressWarnings("WeakerAccess")
public class StringPreference extends AbstractPreference<String> {
    /**
     * @param preferences  where to save the preference
     * @param key          key to the preference
     * @param defaultValue default value for the preference
     */
    public StringPreference(@NonNull SharedPreferences preferences, @NonNull String key, String
            defaultValue) {
        super(preferences, key, defaultValue);
    }

    public String get() {
        return preferences.getString(key, defaultValue);
    }

    public void set(String value) {
        preferences.edit().putString(key, value).apply();
    }
}