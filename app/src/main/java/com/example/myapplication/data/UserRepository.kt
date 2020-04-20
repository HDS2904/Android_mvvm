package com.example.myapplication.data

class UserRepository(private val dao: UserDAO) {

    val users = dao.loadAllProduct()

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