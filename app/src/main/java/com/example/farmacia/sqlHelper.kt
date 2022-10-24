package com.example.farmacia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import androidx.core.content.contentValuesOf

class sqlHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper
    (context, "comedor.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val creacion = "CREATE TABLE recivo (_id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, cantidad TEXT, total double)"
        db.execSQL(creacion)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun add(producto: String, cantidad: String,total: Double){
        val datos = ContentValues()
        datos.put("producto",producto)
        datos.put("cantidad",cantidad)
        datos.put("total",total)

        val db = this.writableDatabase
        db.insert("recivo",null,datos)
        db.close()

    }
}