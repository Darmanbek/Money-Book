package com.example.mydolgiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var myadapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rview.adapter = myadapter
        rview.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        warning_name.isVisible = false
        warning_message.isVisible = false
        warning_summa.isVisible = false
        img_add.setOnClickListener {
            Handler().postDelayed({
                setAdd()
            },1000)
        }

    }

    fun setAdd() {
        val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog,null)
        val dialog = AlertDialog.Builder(this).setView(view).show()
        view.input_edit_name.addTextChangedListener{
            view.warning_name.isVisible = false
        }
        view.input_edit_message.addTextChangedListener{
            view.warning_name.isVisible = false
        }
        view.input_edit_summa.addTextChangedListener{
            view.warning_name.isVisible = false
        }
        view.btn_plus.setOnClickListener {
        if(!view.input_edit_name.text.toString().isEmpty()){
            view.warning_name.isVisible = true
        }else if(!view.input_edit_message.text.toString().isEmpty()){
            view.warning_message.isVisible = true
        }else if(!view.input_edit_summa.text.toString().isEmpty()){
            view.warning_summa.isVisible = true
        }else{
            view.warning_name.isVisible = false
            view.warning_message.isVisible = false
            view.warning_summa.isVisible = false
        }
        if(!(view.input_edit_name.text.toString().isEmpty()&&view.input_edit_message.text.toString().isEmpty()&&
                    view.input_edit_summa.text.toString().isEmpty()||view.input_edit_comment.text.toString().isEmpty())){
            var name = view.input_edit_name.text.toString()
            var message = view.input_edit_message.text.toString()
            var summa = "+"+view.input_edit_summa.text.toString()
            var comment = view.input_edit_comment.text.toString()
            var user = User(name,message,summa,comment)
            set(user)
        }
        }
        view.btn_minus.setOnClickListener {
            if(!view.input_edit_name.text.toString().isEmpty()){
                view.warning_name.isVisible = true
            }else if(!view.input_edit_message.text.toString().isEmpty()){
                view.warning_message.isVisible = true
            }else if(!view.input_edit_summa.text.toString().isEmpty()){
                view.warning_summa.isVisible = true
            }else{
                view.warning_name.isVisible = false
                view.warning_message.isVisible = false
                view.warning_summa.isVisible = false
            }
            if(!(view.input_edit_name.text.toString().isEmpty()&&view.input_edit_message.text.toString().isEmpty()&&
                        view.input_edit_summa.text.toString().isEmpty()||view.input_edit_comment.text.toString().isEmpty())){
                var name = view.input_edit_name.text.toString()
                var message = view.input_edit_message.text.toString()
                var summa = "-"+view.input_edit_summa.text.toString()
                var comment = view.input_edit_comment.text.toString()
                var user = User(name,message,summa,comment)
                set(user)
            }
        }
        view.btn_cancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun set(user: User) {
        var setlist = myadapter.list
        setlist.add(user)
        myadapter.notifyItemInserted(0)
        myadapter.list = setlist
    }
}