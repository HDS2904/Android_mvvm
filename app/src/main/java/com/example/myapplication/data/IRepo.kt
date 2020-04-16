package com.example.myapplication.data

import com.example.myapplication.vo.Resource

interface IRepo {
    suspend fun getVersionAppRepo(): Resource<Int>
}