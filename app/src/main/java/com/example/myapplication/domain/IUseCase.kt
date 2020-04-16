package com.example.myapplication.domain

import com.example.myapplication.vo.Resource

interface IUseCase {
    suspend fun getVersionApp(): Resource<Int>
}