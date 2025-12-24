package com.example.mindnest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mindnest.databinding.ItemJournalMoodBinding
import com.example.mindnest.model.JournalEntry

class JournalAdapter(
    private val list: MutableList<JournalEntry>,
    private val onEditClick: (JournalEntry) -> Unit
) : RecyclerView.Adapter<JournalAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemJournalMoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]

        holder.binding.txtDate.text = "${item.day}\n${item.weekday}"
        holder.binding.txtJournal.text = item.text
        holder.binding.txtMoodEmoji.text = item.mood

        holder.binding.btnEdit.setOnClickListener {
            onEditClick(item)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class VH(val binding: ItemJournalMoodBinding) :
        RecyclerView.ViewHolder(binding.root)
}
