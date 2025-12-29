package com.example.mindnest.ui.water

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class WaterViewModel : ViewModel() {

    private val _entries = MutableLiveData<MutableList<WaterEntry>>(mutableListOf())
    val entries: LiveData<MutableList<WaterEntry>> = _entries

    private val _dailyTarget = MutableLiveData<Int>(0)
    val dailyTarget: LiveData<Int> = _dailyTarget

    fun addWater(amount: Int) {
        val today = getToday()
        val list = _entries.value!!
        list.add(WaterEntry(today, amount, _dailyTarget.value ?: 0))
        _entries.value = list
    }

    fun setTarget(target: Int) {
        _dailyTarget.value = target
    }

    fun todayTotal(): Int {
        val today = getToday()
        return _entries.value?.filter { it.date == today }?.sumOf { it.consumedMl } ?: 0
    }

    fun isTargetAchieved(date: String): Boolean {
        val target = _dailyTarget.value ?: 0
        if (target == 0) return false
        val total = _entries.value?.filter { it.date == date }?.sumOf { it.consumedMl } ?: 0
        return total >= target
    }

    private fun getToday(): String = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())
}
