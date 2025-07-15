package com.example.diaryapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class AddEntryActivity : AppCompatActivity() {

    private val formatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    private var selectedDate: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        val edtDate = findViewById<EditText>(R.id.edtDate)
        edtDate.setText(formatter.format(selectedDate.time))
        edtDate.setOnClickListener { showDatePicker(edtDate) }

        val spinnerMood = findViewById<Spinner>(R.id.spinnerMood)

        // ✅ Kotlin-only emoji mood list
        val moods = listOf("🙂", "😔", "😠", "😐", "😄")  // You can add more here
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, moods)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMood.adapter = adapter

        val edtContent = findViewById<EditText>(R.id.edtContent)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val entry = JournalEntry(
                date = edtDate.text.toString(),
                mood = spinnerMood.selectedItem.toString(),  // ✅ Just emoji!
                text = edtContent.text.toString()
            )
            EntryRepository.saveEntry(this, entry)
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun showDatePicker(edt: EditText) {
        val c = selectedDate
        DatePickerDialog(this, { _, y, m, d ->
            c.set(y, m, d)
            edt.setText(formatter.format(c.time))
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
    }
}
