package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.data.User
import com.example.myapplication.data.UserDatabase
import com.example.myapplication.data.UserRepository
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MainViewModelFactory
import com.example.myapplication.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.items_list.*

class MainActivity : BaseActivity() {

    private val userViewModel: MainViewModel by lazy {
        ViewModelProvider(this,MainViewModelFactory(UserRepository(UserDatabase
            .getInstance(application).userDAO)))
            .get(MainViewModel::class.java)
    }

    override fun getViewIdD(): Int = R.layout.activity_main

    private lateinit var adapter:MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = MainAdapter(this)

        buttonIng.setOnClickListener {
            val name = editTextName.text.toString()
            val precio = editTextPrice.text.toString()
            userViewModel.ingreso(User(0,name,precio))
            editTextName.text = ""
            editTextPrice.text = ""
        }

        buttonDel.setOnClickListener {
            userViewModel.deleteAll()
        }

        recyclerViewItems.layoutManager = LinearLayoutManager(this)
        recyclerViewItems.adapter = adapter

        observando()



    }

    fun observando(){
        userViewModel.usuarios.observe(this, Observer {
            showProgressVisibility(true)
            when(it){
                is Resource.Loading -> {
                    showProgressVisibility(true)
                }
                is Resource.Success -> {
                    showProgressVisibility(false)

                    adapter.setListData(it.data)
                    adapter.notifyDataSetChanged()
                    for (item in it.data){
                        Log.e("USUARIOS LOG: ","id: ${item.id}, name: ${item.name}, price: ${item.price}")
                    }

                    //textView.text = it.data.tittle.toString()
                    //textView2.text = it.data.version.toString()
                    //textView3.text = it.data.color.toString()
                }
                is Resource.Failure -> {
                    Toast.makeText(this,"Ocurrio un error: ${it.exception.message}",Toast.LENGTH_LONG)
                }
            }

        })
    }
    //https://www.youtube.com/watch?v=RJCoCk1YbzM (min:15)

}
