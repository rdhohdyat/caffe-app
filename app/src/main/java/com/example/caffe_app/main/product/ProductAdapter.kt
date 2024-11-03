package com.example.caffe_app.main.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R
import com.squareup.picasso.Picasso

class ProductAdapter(
    private val productList: List<ProductModel>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_card_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productList[position]

        val context = holder.itemView.context

        Picasso.get().load(item.imageUrl).into(holder.imageView)
        holder.name.text = item.name
        holder.price.text = "Rp. ${item.price}"
        holder.category.text = item.category

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "${item.name} di tambahkan ke order", Toast.LENGTH_LONG).show()
        }

        println("Loading item yang ke : $position")
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(ProductView: View) : RecyclerView.ViewHolder(ProductView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)
        val category: TextView = itemView.findViewById(R.id.category)
    }
}
