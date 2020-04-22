package br.android.iddog.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView
import br.android.iddog.R
import br.android.iddog.di.module.User

object SessionUtils {
    fun createSession(context: Context, user: User?) {
        val pref = context.getSharedPreferences(SHARE_PREFS_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()

        val sharedPrefs = context.getSharedPreferences(SHARE_PREFS_NAME, Context.MODE_PRIVATE)
        if (sharedPrefs.contains(USER_COLUMN_NOME) ||
            sharedPrefs.contains(USER_COLUMN_EMAIL)
        ) {
            editor.clear()
        }

        editor.putString(USER_COLUMN_IDTOKEN, user!!.token)
        editor.putString(USER_COLUMN_NOME, user.nome)
        editor.putString(USER_COLUMN_EMAIL, user.email)
        editor.commit()
    }

    fun resetSession(context: Context) {
        val pref = this.getSharedPrefs(context)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
    }

    fun getSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARE_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun checkUserInSession(context: Context, textView: TextView): Boolean {
        val sharedPrefs = context.getSharedPreferences(SHARE_PREFS_NAME, Context.MODE_PRIVATE)
        if (sharedPrefs.contains(USER_COLUMN_NOME)) {
            val sessionUserName = sharedPrefs.getString(USER_COLUMN_NOME, "")
            textView.text = context.resources.getString(R.string.online_user, sessionUserName)
            return true
        } else {
            textView.text = context.resources.getString(R.string.main_sub_title)
            return false
        }
    }

    fun hadUserSession(context: Context): MutableMap<String, *>? {
        val sharedPrefs = context.getSharedPreferences(SHARE_PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPrefs.all
    }
}