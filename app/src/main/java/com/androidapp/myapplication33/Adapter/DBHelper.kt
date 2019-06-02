package com.androidapp.myapplication33.Adapter

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.androidapp.myapplication33.Model.ToDo

class DBHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {

        private val DATABASE_VER = 1
        private val DATABASE_NAME = "TODO.db"
        private val TABLE_NAME = "ToDo"
        private val COL_TITLE = "Title"
        private val COL_DESC = "Description"
        private val COL_ID = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String = (
                "CREATE TABLE $TABLE_NAME  " +
                        "($COL_ID integer PRIMARY KEY AUTOINCREMENT," +
                        "$COL_TITLE TEXT, " +
                        "$COL_DESC TEXT)")

        db!!.execSQL(CREATE_TABLE_QUERY)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addQuestions(toDo: ToDo){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_TITLE,toDo.title)
        values.put(COL_DESC,toDo.description)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun allQuestions():MutableList<ToDo>{
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val toDolist = ArrayList<ToDo>()
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast){
                val toDo = ToDo(cursor.getString(cursor.getColumnIndex("Title")),
                    cursor.getString(cursor.getColumnIndex("Description")))
                toDolist.add(toDo)
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()
        return toDolist
    }

}