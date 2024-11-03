package com.example.caffe_app.main.order

data class OrderModel(
    val imageUrl: String,
    val name: String,
    val total: Int,
    val category: String,
    val quantity : Int
)
