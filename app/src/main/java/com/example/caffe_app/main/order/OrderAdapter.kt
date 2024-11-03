package com.example.caffe_app.main.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R
import com.squareup.picasso.Picasso

class OrderAdapter(
    private val orderList: List<OrderModel>
) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_card_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orderList[position]

        Picasso.get().load(item.imageUrl).into(holder.imageView)
        holder.name.text = item.name
        holder.total.text = "Rp. ${item.total}"
        holder.quantity.text = item.quantity.toString()
        holder.category.text = item.category
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class ViewHolder(orderView: View) : RecyclerView.ViewHolder(orderView) {
        val imageView: ImageView = orderView.findViewById(R.id.imageView)
        val name: TextView = orderView.findViewById(R.id.textName)
        val total: TextView = orderView.findViewById(R.id.textTotal)
        val category: TextView = orderView.findViewById(R.id.textCategory) // pastikan ID sesuai di layout XML
        val quantity: TextView = orderView.findViewById(R.id.textQty)
    }
}
