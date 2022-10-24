package com.example.farmacia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Compra : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var RecivoBD: sqlHelper
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)
            //Listas
        val precio: List<Double> = listOf(1.50, 2.50, 3.50, 1.50, 1.50, 1.25,2.50,1.50,1.50,5.00)
        val productos: List<String> = listOf(" Torta normal","Torta mixta    "," Torta vegana   ","Gordita","Tacos"," Birria normal ","Birria grande ","Ccacola normal  ","Pepsi","Agua")

        //objeto para base de datos

        RecivoBD = sqlHelper(this,"recivo",null,1)

        //botones
        val btnProducto = findViewById<Button>(R.id.btnMenu)
        val btnRegistro = findViewById<Button>(R.id.btnRecibo)

        val btnComprar = findViewById<Button>(R.id.btnComprar)
        //valores


        val txtid = findViewById<EditText>(R.id.txtId)
        val txtcantidad = findViewById<EditText>(R.id.txtCantidad)












        btnComprar.setOnClickListener{
            var id = txtid.text.toString().toInt()

            id -= 1

                val total = txtcantidad.text.toString().toInt() * precio[id]



                RecivoBD.add(productos[id], txtcantidad.text.toString(),total)

                txtid.text.clear()
                txtcantidad.text.clear()

            Toast.makeText(this, "Gracias por comprar!", Toast.LENGTH_SHORT).show()


        }








        //botnes para moverse
        btnProducto.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnRegistro.setOnClickListener{
            startActivity(Intent(this, Recivo::class.java))
        }
    }
}