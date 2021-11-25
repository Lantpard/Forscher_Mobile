package com.example.forscher_mobile.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.forscher_mobile.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}