package com.example.diaryapp

import java.io.Serializable

data class JournalEntry(
    val date: String,
    val mood: String,
    val text: String
) : Serializable
