package com.example.myapplication.data

//import io.opencensus.resource.Resource

class UserRepository(private val dao: UserDAO) {

    suspend fun loadAll(): List<User>{
        return  dao.loadAllProduct()
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