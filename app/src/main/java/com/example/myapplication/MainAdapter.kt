package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.User
import kotlinx.android.synthetic.main.items_list.view.*

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var users = listOf<User>()

    fun setListData(data: List<User>){
        users = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_list,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(users.size > 0){
            users.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.binView(user)
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun binView(user: User){
            itemView.textName.text = user.name
            itemView.textPrecio.text = user.price
        }
    }
}