package com.example.myapplication.domain

import com.example.myapplication.model.App
import com.example.myapplication.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IUseCase {
    suspend fun getAppObj():Flow<Resource<App>>
}