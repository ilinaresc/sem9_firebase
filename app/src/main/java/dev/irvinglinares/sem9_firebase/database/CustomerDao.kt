package dev.irvinglinares.sem9_firebase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CustomerDao {
    //Insert
    @Insert
    fun insert(customer: CustomerEntity)
    //Update
    @Update
    fun update(customer: CustomerEntity)
    //Delete
    @Delete
    fun delete(customer: CustomerEntity)

    @Query("select * from customer")
    fun getAll(): LiveData<List<CustomerEntity>>

    @Query("select * from customer where customer_id = :customerId")
    fun getById(customerId: Int): CustomerEntity

}