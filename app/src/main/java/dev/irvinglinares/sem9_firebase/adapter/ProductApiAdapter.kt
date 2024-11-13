package dev.irvinglinares.sem9_firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.irvinglinares.sem9_firebase.R
import dev.irvinglinares.sem9_firebase.model.ProductApiModel
import dev.irvinglinares.sem9_firebase.model.ProductModel

class ProductApiAdapter(private var lstProducts: List<ProductApiModel>): RecyclerView.Adapter<ProductApiAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivProductApi = itemView.findViewById<ImageView>(R.id.ivProductApi)
        val tvDescriptionApi = itemView.findViewById<TextView>(R.id.tvDescriptionApi)
        val tvPriceApi = itemView.findViewById<TextView>(R.id.tvPriceApi)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_product_api, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ProductApiAdapter.ViewHolder, position: Int) {
        val itemProduct = lstProducts[position]
        holder.tvDescriptionApi.text = itemProduct.description
        holder.tvPriceApi.text = itemProduct.price.toString()
        //Agregar Glide para la imagen
        Glide.with(holder.itemView.context)
            .load(itemProduct.imageUrl)
            .into(holder.ivProductApi)
    }

    override fun getItemCount(): Int {
        return lstProducts.size
    }

    //Método para actualizar la lista de productos
    fun updateListProduct(listProduct: List<ProductApiModel>) {
        lstProducts = listProduct
        notifyDataSetChanged()
    }
}