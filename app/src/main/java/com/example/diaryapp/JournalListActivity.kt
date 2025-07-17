package com.example.diaryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable

class JournalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal_list)

        // 💣 Nuking the saved entries (TEMP only!)
        EntryRepository.clearAllEntries(this)

        val recycler = findViewById<RecyclerView>(R.id.recyclerEntries)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = JournalListAdapter(EntryRepository.getEntries(this)) { entry ->
            val intent = Intent(this, ViewEntryActivity::class.java)
            intent.putExtra("entry", entry as Serializable)
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener {
            startActivity(Intent(this, AddEntryActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        (findViewById<RecyclerView>(R.id.recyclerEntries).adapter as? JournalListAdapter)
            ?.update(EntryRepository.getEntries(this))
    }
}
