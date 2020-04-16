package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.data.RepoImp
import com.example.myapplication.domain.UseCaseImp
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MainViewModelFactory
import com.example.myapplication.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel by lazy { ViewModelProvider(this,MainViewModelFactory(UseCaseImp(RepoImp()))).get(MainViewModel::class.java) }

    override fun getViewIdD(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }

    //https://www.youtube.com/watch?v=RJCoCk1YbzM (min:15)
    private fun observeData(){
        viewModel.versionApp.observe(this, Observer {
            when(it){
                is Resource.Loading -> {
                    showProgressVisibility(true)
                }
                is Resource.Success -> {
                    showProgressVisibility(false)
                    textView.text = it.data.toString()
                }
                is Resource.Failure -> {
                    Toast.makeText(this,"Ocurrio un error: ${it.exception.message}",Toast.LENGTH_LONG)
                }
            }
        })      //Activity: this, Fragment: ViewLyfecycleOwner
    }

}
