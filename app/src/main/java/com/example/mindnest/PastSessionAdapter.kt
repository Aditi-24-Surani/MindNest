package com.example.mindnest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PastSessionAdapter :
    ListAdapter<PastSession, PastSessionAdapter.SessionViewHolder>(DiffCallback()) {

    class SessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: AppCompatTextView = view.findViewById(R.id.tvSessionDate)
        val tvTime: AppCompatTextView = view.findViewById(R.id.tvSessionTime)
        val tvDuration: AppCompatTextView = view.findViewById(R.id.tvSessionDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_past_session, parent, false)
        return SessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val session = getItem(position)

        holder.tvDate.text = session.date
        holder.tvTime.text = session.time
        holder.tvDuration.text = session.duration
    }
    class DiffCallback : DiffUtil.ItemCallback<PastSession>() {
        override fun areItemsTheSame(oldItem: PastSession, newItem: PastSession): Boolean {
            return oldItem.startMillis == newItem.startMillis
        }

        override fun areContentsTheSame(oldItem: PastSession, newItem: PastSession): Boolean {
            return oldItem == newItem
        }
    }

}
