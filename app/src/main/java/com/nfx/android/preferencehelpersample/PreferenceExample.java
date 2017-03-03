package com.nfx.android.preferencehelpersample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nfx.android.preferencehelper.preferences.AbstractPreference;
import com.nfx.android.preferencehelper.preferences.BooleanPreference;
import com.nfx.android.preferencehelper.preferences.StringPreference;

import java.util.ArrayList;
import java.util.List;

public class PreferenceExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        getFragmentManager().beginTransaction().replace(R.id.preferences_fragment,
                new PreferenceFragmentExample()).commit();
    }

    public static class PreferenceFragmentExample extends PreferenceFragment
            implements SharedPreferences.OnSharedPreferenceChangeListener {

        List<AbstractPreference> myList = new ArrayList<>();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.pref_general);

            myList.add(new BooleanPreference(getPreferenceManager().getSharedPreferences(),
                    getString(R.string.pref_social_recommendations_key),
                    getResources().getBoolean(R.bool.pref_social_recommendations_default_value)));
            myList.add(new StringPreference(getPreferenceManager().getSharedPreferences(),
                    getString(R.string.pref_display_name_key),
                    getResources().getString(R.string.pref_display_name_default_value)));
            myList.add(new StringPreference(getPreferenceManager().getSharedPreferences(),
                    getString(R.string.pref_add_friends_to_messages_key),
                    getResources().getString(R.string.pref_add_friends_to_messages_default_value)));

            getPreferenceManager().getSharedPreferences().
                    registerOnSharedPreferenceChangeListener(this);

        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            for(AbstractPreference preference : myList) {
                if(key.equals(preference.getKey())) {
                    Toast.makeText(getActivity().getBaseContext(),
                            "preference : " + preference.getKey() + "\n" +
                                    "value : " + preference.get(),
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
