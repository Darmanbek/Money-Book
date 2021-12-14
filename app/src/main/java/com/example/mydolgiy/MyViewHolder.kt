package com.example.mydolgiy

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view.view.*

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun populateModel(user: User,activity: MainActivity) {
        itemView.tv_name.text = user.name
        itemView.tv_type.text = user.message
        itemView.tv_summa.text = user.sum.toString()
    }
}