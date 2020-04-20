package com.example.myapplication.data

import androidx.room.*

@Dao
interface UserDAO {
        @Insert
        suspend fun insertProduct(user: User): Long

        @Update
        suspend fun updateProduct(user: User)

        @Delete
        suspend fun deleteProduct(user: User)

        @Query("DELETE FROM product_data_table")
        suspend fun deleteAllProduct()

        @Query("SELECT * FROM product_data_table")
        //fun loadAllProduct(): LiveData<List<Product>>
        suspend fun loadAllProduct(): List<User>
        //suspend fun loadAllProduct(): Resource<MutableList<User>>
    }