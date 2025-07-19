package com.example.diaryapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_entry)

        // Grab views by new IDs
        val viewDate = findViewById<TextView>(R.id.viewDate)
        val viewMood = findViewById<TextView>(R.id.viewMood)
        val viewText = findViewById<TextView>(R.id.viewText)

        // Get the journal entry passed from JournalListActivity
        val entry = intent.getSerializableExtra("entry") as? JournalEntry

        entry?.let {
            viewDate.text = it.date
            viewMood.text = it.mood
            viewText.text = it.text
        }
    }
}
