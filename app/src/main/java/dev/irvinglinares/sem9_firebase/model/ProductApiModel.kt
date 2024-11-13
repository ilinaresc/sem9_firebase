package dev.irvinglinares.sem9_firebase.model

data class ProductApiModel(
    val id: Int,
    val description: String,
    val price: Double,
    val stock: Int,
    val imageUrl: String,
    val discount: Double,
    val categoryId: Int
)