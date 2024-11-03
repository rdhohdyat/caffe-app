package com.example.caffe_app.main.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R
import com.example.caffe_app.main.category.CategoryModel

class HomeFragment : Fragment() {
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    private val categories = mutableMapOf<String, CategoryModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        productRecyclerView = view.findViewById(R.id.recyclerView)
        productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        categories["semua"] = CategoryModel(view.findViewById(R.id.semuaLayout), view.findViewById(R.id.semuaText), view.findViewById(R.id.semuaIcon))
        categories["makanan"] = CategoryModel(view.findViewById(R.id.makananLayout), view.findViewById(R.id.makananText), view.findViewById(R.id.makananIcon))
        categories["minuman"] = CategoryModel(view.findViewById(R.id.minumanLayout), view.findViewById(R.id.minumanText), view.findViewById(R.id.minumanIcon))
        categories["snack"] = CategoryModel(view.findViewById(R.id.snackLayout), view.findViewById(R.id.snackText), view.findViewById(R.id.snackIcon))

        categories.forEach { (key, category) ->
            category.layout.setOnClickListener { setActiveCategory(key) }
        }

        setActiveCategory("semua")

        val products = listOf(
            ProductModel(
                imageUrl = "https://www.sugarspicenmore.com/wp-content/uploads/2022/08/Nasi-Goreng-4.jpg",
                name = "Nasi Goreng",
                price = 15000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://images.tokopedia.net/img/JFrBQq/2023/11/17/9f4811eb-7151-47c5-8b97-aa7717218534.jpg",
                name = "Mie Goreng",
                price = 13000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://www.finnafood.com/blog/wp-content/uploads/2024/07/sate-ponorogo.jpg",
                name = "Sate Ayam",
                price = 20000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://img.kurio.network/rE9S29CrLtZ_dW5BiVsp7RufHZw=/1200x1200/filters:quality(80)/https://kurio-img.kurioapps.com/21/11/15/2cbee642-ecd0-4f1f-9d0b-23acb574fe59.jpe",
                name = "Bakso",
                price = 18000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3EwDzPjEYNYK0x5TTecrRyejLfAlFoQZvMg&s",
                name = "Soto Ayam",
                price = 17000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://img-global.cpcdn.com/recipes/ff70ae9c035a4aba/400x400cq70/photo.jpg",
                name = "Ayam Goreng",
                price = 20000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://img.kurio.network/rlKzeW_1_iLZ-JMm9fFHX-rGdIE=/1200x1200/filters:quality(80)/https://kurio-img.kurioapps.com/22/06/22/53264347-b7ba-4257-852d-04e3d1b4e4e5.jpe",
                name = "Gado-Gado",
                price = 15000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://kurio-img.kurioapps.com/21/02/18/aa2e1e4c-5991-4816-9aa8-73b0cc826185.jpe",
                name = "Nasi Uduk",
                price = 14000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://cdn.medcom.id/images/library/images/pecel%20(2).jpg",
                name = "Pecel",
                price = 12000,
                category = "Makanan"
            ),
            ProductModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv5VESYstyAeE99NAxWy0knHviBOAgEoCKbQ&s",
                name = "Rendang",
                price = 25000,
                category = "Makanan"
            )
        )

        adapter = ProductAdapter(products)
        productRecyclerView.adapter = adapter

        return view
    }

    private fun setActiveCategory(activeCategory: String) {
        categories.values.forEach { category ->
            category.layout.background = ContextCompat.getDrawable(requireContext(), R.drawable.bacground_white)
            category.text.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            category.icon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.blue))
        }

        categories[activeCategory]?.let { category ->
            category.layout.background = ContextCompat.getDrawable(requireContext(), R.drawable.button_background)
            category.text.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            category.icon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.white))
        }
    }
}
