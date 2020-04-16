package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.domain.IUseCase
import com.example.myapplication.vo.Resource

class MainViewModel(useCase: IUseCase): ViewModel() {

    val versionApp = liveData  {
        emit(Resource.Loading())
        try {
            val version = useCase.getVersionApp()
            emit(version)
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}