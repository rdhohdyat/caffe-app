package com.example.caffe_app.main.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caffe_app.R

class OrderFragment : Fragment() {
    private lateinit var layouts: List<LinearLayout>
    private lateinit var texts: List<TextView>
    private lateinit var icons: List<ImageView>
    private val paymentMethods = listOf("cash", "qr", "transfer")

    private lateinit var orderRecyclerView: RecyclerView
    private lateinit var adapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        layouts = listOf(
            view.findViewById(R.id.cashLayout),
            view.findViewById(R.id.qrLayout),
            view.findViewById(R.id.transferLayout)
        )
        texts = listOf(
            view.findViewById(R.id.cashText),
            view.findViewById(R.id.qrText),
            view.findViewById(R.id.transferText)
        )
        icons = listOf(
            view.findViewById(R.id.cashIcon),
            view.findViewById(R.id.qrIcon),
            view.findViewById(R.id.transferIcon)
        )

        paymentMethods.forEachIndexed { index, method ->
            layouts[index].setOnClickListener { setActivePaymentMethod(method) }
        }

        setActivePaymentMethod("cash")

        val orders = listOf(
            OrderModel(
                imageUrl = "https://www.sugarspicenmore.com/wp-content/uploads/2022/08/Nasi-Goreng-4.jpg",
                name = "Nasi Goreng",
                total = 15000,
                category = "Makanan",
                quantity = 1
            ),
            OrderModel(
                imageUrl = "https://img-z.okeinfo.net/okz/500/library/images/2019/11/14/ve6a70o9qkye5gtulpyu_19184.jpg",
                name = "Jus Jeruk",
                total = 25000,
                category = "Minuman",
                quantity = 4
            ),
            OrderModel(
                imageUrl = "https://images.tokopedia.net/img/JFrBQq/2023/11/17/9f4811eb-7151-47c5-8b97-aa7717218534.jpg",
                name = "Mie Goreng",
                total = 30000,
                category = "Makanan",
                quantity = 1
            ),
            OrderModel(
                imageUrl = "https://www.finnafood.com/blog/wp-content/uploads/2024/07/sate-ponorogo.jpg",
                name = "Sate Ayam",
                total = 20000,
                category = "Makanan",
                quantity = 1
            ),
            OrderModel(
                imageUrl = "https://img.kurio.network/rE9S29CrLtZ_dW5BiVsp7RufHZw=/1200x1200/filters:quality(80)/https://kurio-img.kurioapps.com/21/11/15/2cbee642-ecd0-4f1f-9d0b-23acb574fe59.jpe",
                name = "Bakso",
                total = 15000,
                category = "Makanan",
                quantity = 1
            )
        )

        orderRecyclerView = view.findViewById(R.id.recyclerView)
        orderRecyclerView.layoutManager = LinearLayoutManager(requireActivity())

        adapter = OrderAdapter(orders)
        orderRecyclerView.adapter = adapter

        return view
    }

    private fun setActivePaymentMethod(method: String) {
        paymentMethods.forEachIndexed { index, currentMethod ->
            val isActive = currentMethod == method
            layouts[index].background = ContextCompat.getDrawable(
                requireContext(),
                if (isActive) R.drawable.button_background_active else R.drawable.button_background_inactive
            )
            texts[index].setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    if (isActive) R.color.white else R.color.blue
                )
            )
            icons[index].setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    if (isActive) R.color.white else R.color.blue
                )
            )
        }
    }
}
