package com.example.mindnest.ui.water

sealed class WaterListItem {
    data class DateHeader(val date: String, val achieved: Boolean = false) : WaterListItem()
    data class WaterLog(val entry: WaterEntry) : WaterListItem()
}
