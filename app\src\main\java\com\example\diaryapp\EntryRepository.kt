package com.example.diaryapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object EntryRepository {
    private const val PREFS_NAME = "entries_prefs"
    private const val KEY_ENTRIES = "entries_json"

    private val gson = Gson()

    fun saveEntry(context: Context, entry: JournalEntry) {
        val list = getEntries(context).toMutableList()
        list.add(0, entry) // newest at top
        val json = gson.toJson(list)
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().putString(KEY_ENTRIES, json).apply()
    }

    fun getEntries(context: Context): List<JournalEntry> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_ENTRIES, "[]")
        val type = object : TypeToken<List<JournalEntry>>() {}.type
        return gson.fromJson(json, type)
    }

    // 💣 Use this to clear all saved entries
    fun clearAllEntries(context: Context) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().remove(KEY_ENTRIES).apply()
    }
}
