package com.example.mindnest

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PastSessionViewModel : ViewModel() {

    private val _pastSessions = MutableLiveData<MutableList<PastSession>>(mutableListOf())
    val pastSessions: LiveData<MutableList<PastSession>> = _pastSessions

    private val PREFS_NAME = "mindful_sessions"
    private val KEY_SESSIONS = "sessions"

    fun addSession(session: PastSession) {
        val list = _pastSessions.value ?: mutableListOf()
        list.add(0, session) // add newest at top
        _pastSessions.value = list
    }

    fun saveSessions(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(_pastSessions.value)
        prefs.edit().putString(KEY_SESSIONS, json).apply()
    }

    fun loadSessions(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_SESSIONS, null)
        if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<MutableList<PastSession>>() {}.type
            val list: MutableList<PastSession> = gson.fromJson(json, type)
            _pastSessions.value = list
        }
    }
}
