package com.example.mydolgiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view.*

class MainActivity : AppCompatActivity() {
    var myadapter = MyAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rview.adapter = myadapter
        rview.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        set()
        img_add.setOnClickListener {
            setAdd()
        }
    }

    fun setAdd() {
        val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog,null)
        val dialog = AlertDialog.Builder(this).setView(view).show()
            view.btn_plus.setOnClickListener {

            }
            view.btn_minus.setOnClickListener {

            }
            view.btn_cancel.setOnClickListener {
                dialog.dismiss()
            }
    }

    fun set() {
        var setlist = mutableListOf<User>()
        if(!tv_name.text.isEmpty()&&!tv_type.text.isEmpty()&&
                !tv_summa.text.isEmpty()){

        }
        myadapter.list = setlist
    }
}