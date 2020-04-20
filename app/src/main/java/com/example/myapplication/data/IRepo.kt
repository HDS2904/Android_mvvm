package com.example.myapplication.data

import com.example.myapplication.model.App
import com.example.myapplication.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IRepo {
    suspend fun getAppObjRepo(): Resource<List<User>>

}