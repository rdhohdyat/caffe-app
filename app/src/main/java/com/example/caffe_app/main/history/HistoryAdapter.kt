package com.example.caffe_app.main.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R

class HistoryAdapter(
    private val historyList: List<HistoryModel>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_card_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = historyList[position]

        holder.description.text = "${item.date} - ${item.paymentMethod}"
        holder.paymentMethod.text = "Rp.${item.total}"
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    class ViewHolder(historyView: View) : RecyclerView.ViewHolder(historyView) {
        val description : TextView = historyView.findViewById(R.id.description)
        val paymentMethod : TextView = historyView.findViewById(R.id.total)
    }
}