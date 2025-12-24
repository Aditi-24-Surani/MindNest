package com.example.mindnest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class JournalEntry(
    var day: String,
    var weekday: String,
    var text: String,
    var monthYear: String,
    var mood: String
)

class JournalViewModel : ViewModel() {

    private val _allJournals = MutableLiveData<MutableList<JournalEntry>>(mutableListOf())
    val allJournals: LiveData<MutableList<JournalEntry>> get() = _allJournals

    fun addJournal(entry: JournalEntry) {
        _allJournals.value?.add(entry)
        _allJournals.value = _allJournals.value
    }

    fun updateJournal(entry: JournalEntry) {
        val list = _allJournals.value
        list?.let {
            val index = it.indexOf(entry)
            if (index != -1) {
                it[index] = entry
                _allJournals.value = it
            }
        }
    }
}
