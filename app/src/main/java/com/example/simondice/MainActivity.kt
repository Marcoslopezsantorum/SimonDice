package com.example.simondice

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int = 0
    var juego = ArrayList<Int>()
    var jugador = ArrayList<Int>()
    var finalizado = false
    val jugar = findViewById<Button>(R.id.botonjugar)
    val comprobarSecuencia = findViewById<Button>(R.id.comprobar)
    var random = (1..4).random()
    var secuencia: Array<Int> = arrayOf(random)
    val toast3 = Toast.makeText(applicationContext, "Repite la secuencia", Toast.LENGTH_SHORT)
    val bot: Button = findViewById(R.id.botonjugar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val azul: Button = findViewById(R.id.BOTONAZUL)
        val amarillo: Button = findViewById(R.id.BOTONAMARILLO)
        val verde: Button = findViewById(R.id.BOTONVERDE)
        val rojo: Button = findViewById(R.id.BOTONROJO)
        val Btnscolor = listOf(azul, amarillo, verde, rojo)

        var job = GlobalScope.launch(Dispatchers.Main) {

            suspendingTask()
        }

        val botonjugar: Button = findViewById(R.id.botonjugar)
        botonjugar.setOnClickListener {

            Log.i("Estado", "Empieza la partida")

            Empezar()

        }

    }

    private fun suspendingTask() {


    }


    private fun Empezar() {
        Log.i("Estado", "Empieza la partida")
        val mostrarRonda: TextView = findViewById(R.id.cuadrotexto)
        mostrarRonda.text = contadorRonda.toString()

        botonjugar.setOnClickListener {


        }




        fun añadirSecuencia(sec: MutableList<Int>) {
            val numb = (1..4).random()
            sec.add(numb)
            Log.d("Estado", "Añadir secuencia")
        }

        fun mostrarRonda() {
            findViewById<TextView>(R.id.cuadrotexto).text = contadorRonda.toString()
        }

        fun checkSecuencia(sec: MutableList<Int>, secUsr: MutableList<Int>): Boolean {
            return sec == secUsr
            Log.d("Estado", "Hacer comprobacion de la secuencia")
        }

        fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>) {
            sec.clear()
            secUsr.clear()
            Log.d("Estado", "Reset del juego")
        }


        fun ejecutarSecuencia(sec: MutableList<Int>, listaBotones: List<Button>) {
            Log.i("Estado", "Empieza la partida")

            CoroutineScope(Dispatchers.Main).launch {
                Log.d("Estado", "Ejecutar secuencia corrutina")
                for (color in sec) {
                    delay(350)

                    listaBotones[color - 1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
                    Log.d("Estado", "Cambiar a blanco")
                    delay(800)
                    when (color) {
                        1 -> listaBotones[color - 1].backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor("red"))
                        2 -> listaBotones[color - 1].backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor("green"))
                        3 -> listaBotones[color - 1].backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor("yellow"))
                        4 -> listaBotones[color - 1].backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor("blue"))
                    }
                }

            }
        }
    }
}




