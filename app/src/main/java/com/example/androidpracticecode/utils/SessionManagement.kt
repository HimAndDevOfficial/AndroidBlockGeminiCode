package com.example.androidpracticecode.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.androidpracticecode.Constants.DEFAULT_COUNT
import com.example.androidpracticecode.Constants.KEY_COUNT
import com.example.androidpracticecode.Constants.PREF_NAME


class SessionManagement(
    val context: Context
) {

    companion object {
        var masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }
   fun updateCount(value: Int) {
       getSharedPreferencesEditor().putInt(KEY_COUNT,value).apply()
   }

   fun getCount() : Int {
       return getSharedPreference().getInt(KEY_COUNT, DEFAULT_COUNT)
   }

    private fun getSharedPreferencesEditor(): SharedPreferences.Editor {
        return getSharedPreference().edit()
    }

    private fun getSharedPreference(): SharedPreferences {
        return EncryptedSharedPreferences.create(
            PREF_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

}