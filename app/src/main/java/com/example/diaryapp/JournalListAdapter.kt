package com.example.diaryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JournalListAdapter(
    private var entries: List<JournalEntry>,
    private val click: (JournalEntry) -> Unit
) : RecyclerView.Adapter<JournalListAdapter.EntryViewHolder>() {

    class EntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDate: TextView = view.findViewById(R.id.txtDate)
        val txtMood: TextView = view.findViewById(R.id.txtMood)
        val txtPreview: TextView = view.findViewById(R.id.txtPreview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entry, parent, false)
        return EntryViewHolder(view)
    }

    override fun getItemCount() = entries.size

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.txtDate.text = entry.date
        holder.txtMood.text = entry.mood
        holder.txtPreview.text = entry.text.lineSequence().firstOrNull() ?: ""
        holder.itemView.setOnClickListener { click(entry) }
    }

    fun update(newEntries: List<JournalEntry>) {
        entries = newEntries
        notifyDataSetChanged()
    }
}
