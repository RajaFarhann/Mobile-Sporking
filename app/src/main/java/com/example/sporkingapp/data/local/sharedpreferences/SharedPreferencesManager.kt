package com.example.sporkingapp.data.local.sharedpreferences

import android.content.Context
import com.example.sporkingapp.utils.PreferencesKey.EMAIL_KEY
import com.example.sporkingapp.utils.PreferencesKey.EMAIL_PREF
import com.example.sporkingapp.utils.PreferencesKey.PASSWORD_KEY

class SharedPreferencesManager(context: Context){
    private val preferences = context.getSharedPreferences(EMAIL_PREF, Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    var email
        get() = preferences.getString(EMAIL_KEY, "")
        set(value) {
            editor.putString(EMAIL_KEY, value)
            editor.commit()
        }

    var password
        get() = preferences.getString(PASSWORD_KEY, "")
        set(value) {
            editor.putString(PASSWORD_KEY, value)
            editor.commit()
        }

    fun clear() {
        editor.clear()
        editor.commit()
    }
}