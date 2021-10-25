package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonjugar: Button = findViewById(R.id.botonjugar)
        botonjugar.setOnClickListener {

            Log.i ("Estado" , "Empieza la partida")

            Empezar()






        }

    }
    private fun Empezar(){
        Log.i ("Estado" , "Empieza la partida")
        val mostrarRonda: TextView = findViewById(R.id.cuadrotexto)
        mostrarRonda.text = contadorRonda.toString()


    }

    private fun ejecutarSecuencia(){
        Log.i ("Estado" , "Empieza la partida")

        val miTexto: TextView = findViewById(R.id.BOTONAMARILLO)
        val botonamarillo = GlobalScope.launch(Dispatchers.Main){

            suspendingTask(miTexto)
        }

    }

    private fun suspendingTask(miTexto: TextView) {
        miTexto.text ="Aquí"
    }


}