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

        val azul: Button = findViewById(R.id.BOTONAZUL)
        val amarillo: Button = findViewById(R.id.BOTONAMARILLO)
        val verde : Button = findViewById(R.id.BOTONVERDE)
        val rojo : Button = findViewById(R.id.botonrojo)
        val Btnscolor = listOf(azul,amarillo,verde,rojo)

        var job = GlobalScope.launch(Dispatchers.Main) {

            suspendingTask()
        }

        val botonjugar: Button = findViewById(R.id.botonjugar)
        botonjugar.setOnClickListener {

            Log.i ("Estado" , "Empieza la partida")

            Empezar()

        }

    }

    private fun suspendingTask() {

    }


    private fun Empezar(){
        Log.i ("Estado" , "Empieza la partida")
        val mostrarRonda: TextView = findViewById(R.id.cuadrotexto)
        mostrarRonda.text = contadorRonda.toString()


    }

    private fun ejecutarSecuencia(){
        Log.i ("Estado" , "Empieza la partida")

        selectColor += (0..3) random()
        for (i in roundCounter[i]) {
            when (selectColor[1]){

             0-> {
                 job = GlobalScope.launch(Dispatchers.Main){
                     suspendingTask()
                 }
             }
             1-> {
                 job = GlobalScope.launch(Dispatchers.Main){
                        suspendingTask()
                 }
                }
             2-> {
                  job = GlobalScope.launch(Dispatchers.Main){
                        suspendingTask()
                    }
                }

             3-> {
                  job = GlobalScope.launch(Dispatchers.Main){
                        suspendingTask()
                    }
                }

            }

        }




        /*val miTexto: TextView = findViewById(R.id.BOTONAMARILLO)
        val botonamarillo = GlobalScope.launch(Dispatchers.Main){

            suspendingTask(miTexto)
}
*/
    }




private fun suspendingTask(miTexto: TextView) {
        miTexto.text ="Aquí"
    }


}