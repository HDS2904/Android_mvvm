package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.domain.IUseCase
import com.example.myapplication.vo.Resource
import kotlinx.coroutines.flow.collect

class MainViewModel(useCase: IUseCase): ViewModel() {

    val versionApp = liveData {
        emit(Resource.Loading())
        try {
            //val version = useCase.getAppObj()
            //emit(version)
            useCase.getAppObj().collect {
                emit(it)
            }
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}