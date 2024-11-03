package com.example.caffe_app.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R

class HistoryFragment : Fragment() {
    private lateinit var historyRecyclerView: RecyclerView
    private lateinit var adapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_history, container, false)

        val history = listOf(
            HistoryModel(
                paymentMethod = "Cash",
                date = "Sun, Sep 12 2024, 13.00",
                total = 15000,
            ),
             HistoryModel(
                paymentMethod = "Cash",
                date = "Sun, Sep 12 2024, 13.00",
                total = 12000,
            ),
             HistoryModel(
                paymentMethod = "Cash",
                date = "Sun, Sep 12 2024, 13.00",
                total = 35000,
            ),
             HistoryModel(
                paymentMethod = "Cash",
                date = "Sun, Sep 12 2024, 13.00",
                total = 13000,
            ),
        )

        historyRecyclerView = view.findViewById(R.id.recyclerView)
        historyRecyclerView.layoutManager = LinearLayoutManager(requireActivity())

        adapter = HistoryAdapter(history)
        historyRecyclerView.adapter = adapter
        return view
    }
}
