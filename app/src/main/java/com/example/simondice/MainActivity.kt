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

        Log.d("Estado", "onCreate")

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
            Log.d("Estado", "Comprobar")
            contadorRonda++
            if (finalizado == false) {
                if (checkSecuencia(game, jugador)) {
                    Log.d("Estado", "pasate")
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
                    Log.d("Estado", "pierdes")
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

    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>) {
        sec.clear()
        secUsr.clear()
        Log.d("Estado", "Reset del juego")
    }

    fun añadirSecuenciaUsuario(secUsr: MutableList<Int>, color: Int) {

        secUsr.add(color)
        Log.d("Estado", "Añadir secuencia usuario")
    }

    fun ejecutarSecuencia(sec: MutableList<Int>, listaBotones: List<Button>) {
        CoroutineScope(Dispatchers.Main).launch {
            for (color in sec) {
                delay(350)

                listaBotones[color-1].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#030202"))
                Log.d("Estado", "Cambiar a negro")
                delay(450)
                when (color) {
                    1 -> listaBotones[color-1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("green"))
                    2 -> listaBotones[color-1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("blue"))
                    3 -> listaBotones[color-1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("yellow"))
                    4 -> listaBotones[color-1].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("red"))
                }
            }
            var t = Toast.makeText(applicationContext, "Repite", Toast.LENGTH_SHORT)
            t.show()
            Log.d("Estado", "Repite secuencia")
        }
    }
}
