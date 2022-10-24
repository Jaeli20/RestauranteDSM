package com.example.farmacia

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Recivo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var RecivoBD: sqlHelper

    @SuppressLint("WrongViewCast", "MissingInflatedId", "Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)

        val btnConsulta = findViewById<Button>(R.id.btnConsultar)
        val tvRegistro = findViewById<TextView>(R.id.txtRegistro)

        val tvRow1 = findViewById<TextView>(R.id.Row1)
        val tvRow2 = findViewById<TextView>(R.id.Row2)
        val tvRow3 = findViewById<TextView>(R.id.Row3)

        RecivoBD = sqlHelper(this,"recivo",null,1)







        btnConsulta.setOnClickListener{
            tvRegistro.text=" "
            val db : SQLiteDatabase = RecivoBD.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM recivo",null)

            if (cursor.moveToFirst()){
                do {


                    tvRow1.append( cursor.getString(1).toString() +"\n")

                    tvRow2.append( cursor.getString(2).toString()+"\n")

                    tvRow3.append( "$"+cursor.getDouble(3).toString()+"\n")

                }while (cursor.moveToNext())
            }

        }

        val btnTienda = findViewById<Button>(R.id.btnMenu)
        val btnProducto = findViewById<Button>(R.id.btnRecibo)

        btnTienda.setOnClickListener{
            startActivity(Intent(this,Compra::class.java))
        }

        btnProducto.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}