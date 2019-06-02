package com.androidapp.myapplication33

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.androidapp.myapplication33.Adapter.DBHelper
import com.androidapp.myapplication33.Adapter.toDoAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var listNumber : TextView? = null

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DBHelper(this)
        val  toDoList = db.allQuestions()


        this.listNumber = findViewById(R.id.txtList) as TextView

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager

        val adapter = toDoAdapter(this, toDoList)
        recyclerView.adapter= adapter

        //loadList()
       /* var sharedPreferences: SharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        var gson = Gson()
        var json: String? = sharedPreferences.getString("task list", null)
        val itemType = object : TypeToken<ArrayList<ToDo>>() {}.type
        var toDoList : ArrayList<ToDo>? = gson.fromJson(json, itemType)*/
        //////////////
       // var titleScreen= intent.getStringExtra("title")
        //var descriptionScreen = intent.getStringExtra("description")
        //toDoList?.add(ToDo(titleScreen,descriptionScreen))
      //  listNumber?.text = toDoList?.size.toString()


        btnAddNew.setOnClickListener{
            //saveList()
          /*  var editor: SharedPreferences.Editor = sharedPreferences.edit()
            //   var gson: Gson? = null
            //  var json: String = gson!!.toJson(toDoList)
            val gson = Gson()
            val json = gson.toJson(toDoList)
            editor.putString("task list", json)
            editor.apply()*/
            val intent = Intent (this, OtherActivity::class.java)
            startActivity (intent)
        }



    }

   /* fun saveList(){
        var sharedPreferences: SharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPreferences.edit()
        //   var gson: Gson? = null
        //  var json: String = gson!!.toJson(toDoList)
        val gson = Gson()
        val json = gson.toJson(toDoList)
        editor.putString("task list", json)
        editor.apply()

    }*/

   /* fun loadList(){
        var sharedPreferences: SharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        var gson = Gson()
        var json: String = sharedPreferences.getString("task list", null)
        val itemType = object : TypeToken<List<ToDo>>() {}.type
        var toDoList : ArrayList<ToDo> = gson.fromJson(json, itemType)


    }*/

   /* fun addSomething(titleScreen: String, descriptionScreen: String){
        toDoList.add(ToDo(titleScreen,descriptionScreen))
    }*/



}