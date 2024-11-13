package dev.irvinglinares.sem9_firebase.ui.gallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.irvinglinares.sem9_firebase.database.CustomerEntity
import dev.irvinglinares.sem9_firebase.database.CustomerRepository

class GalleryViewModel (application: Application) : AndroidViewModel(application) {

    private var repository = CustomerRepository(application)
    val customers = repository.getCustomers()

    fun saveCustomer(customerEntity: CustomerEntity) {
        repository.insert(customerEntity)
    }
}