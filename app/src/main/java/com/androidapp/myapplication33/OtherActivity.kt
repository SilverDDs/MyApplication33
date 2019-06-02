package com.androidapp.myapplication33

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.androidapp.myapplication33.Adapter.DBHelper
import com.androidapp.myapplication33.Model.ToDo
import kotlinx.android.synthetic.main.activity_other.*



class OtherActivity : AppCompatActivity() {

    private var titleScreen : EditText? = null
    private var descriptionScreen :EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_other)

    val db = DBHelper(this)
        val  toDoList:MutableList<ToDo>? = db.allQuestions()

        titleScreen = findViewById(R.id.editTextTitle) as EditText
    descriptionScreen = findViewById(R.id.editTextDescription) as EditText

    val todo = ToDo(titleScreen?.text.toString(), descriptionScreen?.text.toString())


    btnAdd.setOnClickListener{

        db.addQuestions(todo)
        val intent = Intent (this, MainActivity::class.java)
        startActivity (intent)
    }



}}
