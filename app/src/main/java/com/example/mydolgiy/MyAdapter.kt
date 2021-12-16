package com.example.mydolgiy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_view.view.*

class MyAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    var list:MutableList<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(list[position])
    }

    override fun getItemCount(): Int = list.size

}