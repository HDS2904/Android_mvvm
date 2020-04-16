package com.example.myapplication.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewIdD())
    }

    protected abstract fun getViewIdD(): Int

    fun showProgressVisibility(estado: Boolean){
        if(estado)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE
    }

}