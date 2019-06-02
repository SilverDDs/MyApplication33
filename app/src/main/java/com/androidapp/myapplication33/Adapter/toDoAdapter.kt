package com.androidapp.myapplication33.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidapp.myapplication33.R
import com.androidapp.myapplication33.Model.ToDo
import kotlinx.android.synthetic.main.card_view.view.*


class toDoAdapter(val context: Context, private val toDoList: MutableList<ToDo>) : RecyclerView.Adapter<toDoAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = toDoAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val toDo = toDoList[position]
        holder.setData(toDo, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title1: TextView = itemView.findViewById(R.id.txvTitle)
        val description1: TextView = itemView.findViewById(R.id.txvDescription)

        var currenttoDo: ToDo? = null
        var currentPosition: Int = 0

/*
        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked !")
                }
            }

            itemView.imgShare.setOnClickListener {

                currentHobby?.let {
                    val message: String = "My hobby is: " + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Please select app: "))
                }
            }
        }*/

        fun setData(toDo: ToDo?, pos: Int) {
            toDo?.let {
                title1.text = toDo.title
                description1.text = toDo.description


            }

            this.currenttoDo = toDo
            this.currentPosition = pos
        }
    }
}
