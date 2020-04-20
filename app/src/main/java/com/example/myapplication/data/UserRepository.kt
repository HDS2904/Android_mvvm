package com.example.myapplication.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//import io.opencensus.resource.Resource

class UserRepository(private val dao: UserDAO) {

    fun loadAll(): Flow<List<User>> {
        return dao.loadAllProduct()
    }

    //val products = dao.loadAllProduct()

    suspend fun insert(user: User){
        dao.insertProduct(user)
    }

    suspend fun update(user: User){
        dao.updateProduct(user)
    }

    suspend fun deleteAll(){
        dao.deleteAllProduct()
    }
}