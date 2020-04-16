package com.example.myapplication.domain

import com.example.myapplication.data.IRepo
import com.example.myapplication.vo.Resource

class UseCaseImp (private val repo: IRepo): IUseCase {
    override suspend fun getVersionApp(): Resource<Int> = repo.getVersionAppRepo()
}