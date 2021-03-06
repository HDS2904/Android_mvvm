package com.example.myapplication.domain

import com.example.myapplication.data.IRepo
import com.example.myapplication.model.App
import com.example.myapplication.vo.Resource
import kotlinx.coroutines.flow.Flow

class UseCaseImp (private val repo: IRepo): IUseCase {
    override suspend fun getAppObj(): Flow<Resource<App>> = repo.getAppObjRepo()


}