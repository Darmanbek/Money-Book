package com.example.mydolgiy

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view.view.*

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun populateModel(user: User) {
        itemView.tv_name.text = user.name
        itemView.tv_type.text = user.message
        itemView.tv_summa.text = user.sum
        if(user.toString().contains("+")){
            itemView.tv_summa.setTextColor(Color.GREEN)
        }else{
            itemView.tv_summa.setTextColor(Color.RED)
        }
    }
}