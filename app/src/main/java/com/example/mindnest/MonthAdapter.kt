package com.example.mindnest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mindnest.R
import com.example.mindnest.databinding.ItemMonthChipBinding

class MonthAdapter(
    private val months: List<String>,
    private val onMonthClick: (String) -> Unit
) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val binding = ItemMonthChipBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(months[position], position == selectedPosition)
    }

    override fun getItemCount(): Int = months.size

    fun setSelected(month: String) {
        val newPosition = months.indexOf(month)
        if (newPosition == -1) return

        val oldPosition = selectedPosition
        selectedPosition = newPosition

        if (oldPosition != RecyclerView.NO_POSITION) notifyItemChanged(oldPosition)
        notifyItemChanged(selectedPosition)
    }

    inner class MonthViewHolder(
        private val binding: ItemMonthChipBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(month: String, isSelected: Boolean) {
            val context = binding.root.context

            binding.txtMonth.text = month

            if (isSelected) {
                binding.txtMonth.setTextColor(context.getColor(android.R.color.white))
                binding.txtMonth.setBackgroundResource(R.drawable.bg_month_selected)
            } else {
                binding.txtMonth.setTextColor(context.getColor(R.color.lavender_dark))
                binding.txtMonth.setBackgroundResource(R.drawable.bg_month_unselected)
            }

            binding.root.setOnClickListener {
                val clickedPosition = adapterPosition
                if (clickedPosition == RecyclerView.NO_POSITION) return@setOnClickListener

                val previousPosition = selectedPosition
                selectedPosition = clickedPosition

                if (previousPosition != RecyclerView.NO_POSITION) {
                    notifyItemChanged(previousPosition)
                }
                notifyItemChanged(selectedPosition)

                onMonthClick(months[clickedPosition])
            }
        }
    }
}
