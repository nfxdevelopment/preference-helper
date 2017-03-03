package com.nfx.android.preferencehelper.preferences;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * NFX Development
 * Created by nick on 3/03/17.
 */
public abstract class AbstractPreference<T> {
    /**
     * The shared preference instance to store the boolean in
     */
    protected final SharedPreferences preferences;
    /**
     * The default value for the preference
     */
    protected final T defaultValue;
    /**
     * The key which the preference is stored under
     */
    final String key;

    /**
     * @param preferences  where to save the preference
     * @param key          key to the preference
     * @param defaultValue default value for the preference
     */
    AbstractPreference(@NonNull SharedPreferences preferences,
                       @NonNull String key, T defaultValue) {
        this.preferences = preferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    /**
     * Get the preference
     *
     * @return current value stored in preferences or default value if no instance is stored
     */
    public abstract T get();

    /**
     * Set the value of the preference
     *
     * @param value value to set
     */
    public abstract void set(T value);

    /**
     * Has the preference been set previously
     *
     * @return true if the preference is stored, false if there is no instance
     */
    public boolean isSet() {
        return preferences.contains(key);
    }

    /**
     * Remove instance of preference from preferences
     */
    @SuppressWarnings("WeakerAccess")
    public void delete() {
        preferences.edit().remove(key).apply();
    }

    /**
     * The string of the key
     *
     * @return a string of the key name
     */
    public String getKey() {
        return key;
    }
}
