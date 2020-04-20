package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.User
import com.example.myapplication.data.UserRepository
import com.example.myapplication.domain.IUseCase
import com.example.myapplication.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: UserRepository): ViewModel() {
    /*
    val versionApp = liveData {
        emit(Resource.Loading())
        try {
            val version = useCase.getAppObj()
            emit(version)
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }*/

    val usuarios = liveData {
        repository.loadAll().collect {
            emit(it)
        }
    }
    /*
    val usuarios: Flow<List<User>> = flow {
        emit(repository.loadAll())
    }*/

    fun ingreso(){

        viewModelScope.launch {
                //repository.deleteAll()
                repository.insert(User(0,"siEntro","45.5"))

        }

    }

}