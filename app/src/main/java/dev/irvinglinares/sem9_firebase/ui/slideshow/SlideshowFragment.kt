package dev.irvinglinares.sem9_firebase.ui.slideshow

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.irvinglinares.sem9_firebase.R
import dev.irvinglinares.sem9_firebase.adapter.ProductAdapter
import dev.irvinglinares.sem9_firebase.adapter.ProductApiAdapter
import dev.irvinglinares.sem9_firebase.databinding.FragmentSlideshowBinding
import dev.irvinglinares.sem9_firebase.model.ProductApiModel
import dev.irvinglinares.sem9_firebase.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class SlideshowFragment : Fragment() {

    private var lstProducts = listOf<ProductApiModel>()
    private lateinit var productApiAdapter: ProductApiAdapter
    private lateinit var etSearchProduct: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_slideshow, container, false)
        var rvProductApi = view.findViewById<RecyclerView>(R.id.rvProductApi)
        var etSearchProduct = view.findViewById<EditText>(R.id.etSearchProduct)

        rvProductApi.layoutManager = LinearLayoutManager(requireContext())
        productApiAdapter = ProductApiAdapter(lstProducts)
        rvProductApi.adapter = productApiAdapter

        //Llamar a la carga de productos
        loadProducts()

        configureSearch()

        return view
    }

    private fun configureSearch() {
        //etSearchProduct text changed
        etSearchProduct.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filterProducts(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })
    }

    //Función para filtrar los productos
    private fun filterProducts(query: String) {
        val filteredList = lstProducts.filter { product ->
            product.description.contains(query, ignoreCase = true)
        }
        productApiAdapter.updateListProduct(filteredList)
    }

    private fun loadProducts() {
        val call = RetrofitInstance.api.getProducts()
        call.enqueue(object : retrofit2.Callback<List<ProductApiModel>> {
            override fun onResponse(
                call: Call<List<ProductApiModel>>,
                response: Response<List<ProductApiModel>>
            ) {
                if (response.isSuccessful) {
                    lstProducts = response.body() ?: emptyList()
                    productApiAdapter.updateListProduct(lstProducts)
                }
            }

            override fun onFailure(call: Call<List<ProductApiModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}