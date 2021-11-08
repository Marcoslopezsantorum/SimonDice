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
    var contadorRonda = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var game = ArrayList<Int>()
        var jugador = ArrayList<Int>()
        val bot: Button = findViewById(R.id.botonjugar)
        val empezar = findViewById<Button>(R.id.botonjugar)
        var finalizado = false
        val comprobar = findViewById<Button>(R.id.comprobar)
        val verde = findViewById<Button>(R.id.BOTONVERDE)
        val azul = findViewById<Button>(R.id.BOTONAZUL)
        val amarillo = findViewById<Button>(R.id.BOTONAMARILLO)
        val rojo = findViewById<Button>(R.id.BOTONROJO)
        val listaBotones = listOf(verde, azul, amarillo, rojo)
        val toast = Toast.makeText(applicationContext, "A llorar con mama", Toast.LENGTH_SHORT)
        val toast3 = Toast.makeText(applicationContext, "Ya sabes que hacer", Toast.LENGTH_SHORT)

        empezar.setOnClickListener {
            finalizado = false
            reset(game, jugador)
            añadirSecuencia(game)
            ejecutarSecuencia(game, listaBotones)
            toast3.show()
            mostrarRonda()
            bot.visibility = View.INVISIBLE
            Log.d("Estado", "Jugar")
        }

        comprobar.setOnClickListener {
            Log.d("Estado", "Comprobar secuencia")
            contadorRonda++
            if (finalizado == false) {
                if (checkSecuencia(game, jugador)) {
                    Log.d("Estado", "Ronda acertada")
                    añadirSecuencia(game)
                    jugador.clear()
                    ejecutarSecuencia(game, listaBotones)
                    mostrarRonda()
                } else {
                    finalizado = true
                    toast.show()
                    contadorRonda = 0
                    val bot: Button = findViewById(R.id.botonjugar)
                    bot.visibility = View.VISIBLE
                    Log.d("Estado", "GAME OVER")
                }
            }

        }

        verde.setOnClickListener {
            añadirSecuenciaUsuario(jugador, 1)
        }
        azul.setOnClickListener {
            añadirSecuenciaUsuario(jugador, 2)
        }
        amarillo.setOnClickListener {
            añadirSecuenciaUsuario(jugador, 3)
        }
        rojo.setOnClickListener {
            añadirSecuenciaUsuario(jugador, 4)
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

