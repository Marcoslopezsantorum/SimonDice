package com.example.simondice

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var contadorRonda: Int = 0

    var random = (1..4).random()
    var secuencia:Array<Int> = arrayOf(random)



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

            Log.i("Estado", "Empieza la partida")

            Empezar()

        }

    }

    private fun suspendingTask() {

<<<<<<< HEAD
    }
=======
        }
>>>>>>> añado el juego para que funcione

    }

<<<<<<< HEAD
    private fun Empezar(){
        Log.i ("Estado" , "Empieza la partida")
        val mostrarRonda: TextView = findViewById(R.id.cuadrotexto)
        mostrarRonda.text = contadorRonda.toString()
=======
    private fun Empezar() {
        botonjugar.setOnClickListener {
            finalizado = false
            reset(juego, jugador)
            añadirSecuencia(juego)
            ejecutarSecuencia(juego, listaBotones)
            toast3.show()
            mostrarRonda()
            bot.visibility = View.INVISIBLE
            Log.d("Estado", "Jugar")
        }

        comprobarSecuencia.setOnClickListener {
            Log.d("Estado", "Comprobar secuencia")
            contadorRonda++
            if (finalizado == false) {
                if (checkSecuencia(juego, jugador)) {
                    Log.d("Estado", "Ronda acertada")
                    añadirSecuencia(juego)
                    jugador.clear()
                    ejecutarSecuencia(juego, listaBotones)
                    mostrarRonda()
                } else {
                    finalizado = true
                    toast.show()
                    contadorRonda = 0
                    val bot: Button = findViewById(R.id.jugar)
                    bot.visibility = View.VISIBLE
                    Log.d("Estado", "GAME OVER")
                }
            }

    }
>>>>>>> añado el juego para que funcione

    fun checkSecuencia(sec: MutableList<Int>, secUsr: MutableList<Int>): Boolean {
        return sec == secUsr
        Log.d("Estado", "Hacer comprobacion de la secuencia")
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>) {
        sec.clear()
        secUsr.clear()
        Log.d("Estado", "Reset del juego")
    }


<<<<<<< HEAD
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
=======
    fun añadirSecuenciaUsuario(secUsr: MutableList<Int>, color: Int) {
        secUsr.add(color)
        Log.d("Estado", "Añadir secuencia usuario")
    }



    fun ejecutarSecuencia(sec: MutableList<Int>, listaBotones: List<Button>) {
        Log.i("Estado", "Empieza la partida")

        /* var arrayBotones = hashMapOf<Int,Button>()
        arrayBotones[0]= findViewById(R.id.BOTONAMARILLO)
        arrayBotones[1]= findViewById(R.id.BOTONROJO)
        arrayBotones[2] = findViewById(R.id.BOTONAZUL)
        arrayBotones[3] = findViewById(R.id.BOTONVERDE)
*/




    val amarillo: Button = findViewById(R.id.BOTONAMARILLO)
    val rojo: Button = findViewById(R.id.BOTONROJO)
    val azul: Button = findViewById(R.id.BOTONAZUL)
    val verde: Button = findViewById(R.id.BOTONVERDE)

    val listaBotones = listOf(rojo, verde, amarillo, azul)

    /*
        val amarilloo = GlobalScope.launch(Dispatchers.Main){
        suspendingTask(amarillo)
        }

        val rojoo = GlobalScope.launch(Dispatchers.Main){
        suspendingTask1(rojo)
        }

        val azull = GlobalScope.launch(Dispatchers.Main){
            suspendingTask2(azul)
        }

        val verdee = GlobalScope.launch(Dispatchers.Main){
            suspendingTask3(verde)
        }




    private fun suspendingTask3(verde: Button) {
        verde.setBackgroundColor()
    }

    private fun suspendingTask2(azul: Button) {
        TODO("Not yet implemented")
>>>>>>> añado el juego para que funcione
    }

    private fun suspendingTask1(rojo: Button) {
        TODO("Not yet implemented")
    }

    private fun suspendingTask(amarillo: Button) {
        TODO("Not yet implemented")
    }
*/



        Log.d("Estado", "Ejecutar secuencia")
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




