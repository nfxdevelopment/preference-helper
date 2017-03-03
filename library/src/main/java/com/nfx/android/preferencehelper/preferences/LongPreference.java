package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * NFX Development
 * Created by nick on 19/09/16.
 * <p/>
 * A wrapper around a long preference for ease of access
 */
@SuppressWarnings("WeakerAccess")
public class LongPreference extends AbstractPreference<Long> {
    /**
     * @param preferences  where to save the preference
     * @param key          key to the preference
     * @param defaultValue default value for the preference
     */
    public LongPreference(@NonNull SharedPreferences preferences, @NonNull String key, Long
            defaultValue) {
        super(preferences, key, defaultValue);
    }

    public Long get() {
        return preferences.getLong(key, defaultValue);
    }

    public void set(Long value) {
        preferences.edit().putLong(key, value).apply();
    }
}