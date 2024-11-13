package dev.irvinglinares.sem9_firebase.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.irvinglinares.sem9_firebase.R
import dev.irvinglinares.sem9_firebase.database.CustomerEntity
import dev.irvinglinares.sem9_firebase.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)

        val etFirstName: TextView = view.findViewById(R.id.etFirstName)
        val etLastName: TextView = view.findViewById(R.id.etLastName)
        val etPhoneNumber: TextView = view.findViewById(R.id.etPhoneNumber)
        val  btSaveCustomer: Button = view.findViewById(R.id.btSaveCustomer)

        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        //Click button
        btSaveCustomer.setOnClickListener {
            val customerEntity = CustomerEntity(
                etFirstName.text.toString(),
                etLastName.text.toString(),
                etPhoneNumber.text.toString()
            )
            viewModel.saveCustomer(customerEntity)
        }
        return view
    }
}