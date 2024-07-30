 package com.example.nuncanunca

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

 class PlayingActivity : AppCompatActivity() {
     private val frases = arrayOf(
         "Yo Nunca Nunca he peleado en el colegio",
         "Yo Nunca Nunca he robado en el supermercado",
         "Yo Nunca Nunca he recomendado una película que después me arrepienta",
         "Yo Nunca Nunca me he caido en la calle",
         "Yo Nunca Nunca me he arrepentido de tener sexo con alguien",
         "Yo Nunca Nunca he sido estafado",
         "Yo Nunca Nunca he avergonzado a mi familia por causa estado de ebriedad",
         "Yo Nunca Nunca he gastado mas de 100 mil pesos en un bar",
         "Yo Nunca Nunca he pasado una noche en la carcel",
         "Yo Nunca Nunca me ha pillado la policia conduciendo sin licencia",
         "Yo Nunca Nunca he tenido una accidente automovilístico",
         "Yo Nunca Nunca he robado algo de un hotel",
         "Yo Nunca Nunca he usado Tinder",
         "Yo Nunca Nunca he hecho trampa en un juego de mesas",
         "Yo Nunca Nunca he hecho una serenata",
         "Yo Nunca Nunca he hecho broma telefónica",
         "Yo Nunca Nunca he estado enamorado de alguien imposible",
         "Yo Nunca Nunca he celado a mi pareja",
         "Yo Nunca Nunca he celado a mis amig@s",
         "Yo Nunca Nunca he sufrido Bullying",
         "Yo Nunca Nunca he enviado cartas de amor",
         "Yo Nunca Nunca le he interrumpido un coito a un amigo sin querer",
         "Yo Nunca Nunca he hecho una turbo chela",
         "Yo Nunca Nunca he fingido saber algo que no sabía",
         "Yo Nunca Nunca he estado a punto de ahogarme en el mar",
         "Yo Nunca Nunca he pirateado un juego",
         "Yo Nunca Nunca me he enojado en un juego llamado UNO",
         "Yo Nunca Nunca he tirado licencia médica para tener mas días de descanso",
         "Yo Nunca Nunca he disparado un arma de Verdad",
         "Yo Nunca Nunca he cantado karaokes",
         "Yo Nunca Nunca he Bailado Axe Bahía",
         "Yo Nunca Nunca he falsificado la firma de mis padres",
         "Yo Nunca Nunca he mentido con mi Edad",
         "Yo Nunca Nunca me he pegado mi peor borrachera con vodka",
         "Yo Nunca Nunca me he demorado tanto en arreglarme para salir",
         "Yo Nunca Nunca he visto algo paranormal",
         "Yo Nunca Nunca me he caido en bicicleta o moto",
         "Yo Nunca Nunca he espiado a mi pareja",
         "Yo Nunca Nunca he sido pillado masturbandome",
         "Yo Nunca Nunca he pasado verguenza en un baño ageno",
         "Yo Nunca Nunca he bailado bajo la lluvia",
         "Yo Nunca Nunca le he dicho a mi herman@ que es adoptad@",
         "Yo Nunca Nunca he tenido relaciones sexuales en la playa o campo",
         "Yo Nunca Nunca he conducido ebri@",
         "Yo Nunca Nunca he jalado cocaina",
         "Yo Nunca Nunca he probado éctasis ",
         "Yo Nunca Nunca he bailado arriba de una mesa",
         "Yo Nunca Nunca he regalado peluches en san valentin",
         "Yo Nunca Nunca he ido acampar",
         "Yo Nunca Nunca he provocado una pelea",

     )
     private val frasesMostradas = mutableListOf<String>()

     private val image = arrayOf(
         R.drawable.sorbo1,
         R.drawable.sorbo2,
         R.drawable.sorbo3
     )

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContentView(R.layout.activity_playing)
         val Btnsiguiente: ImageButton = findViewById(R.id.btnsiguiente)
         val Tvfrases: TextView = findViewById(R.id.txtfrases)
         val Ivsorbos: ImageView = findViewById(R.id.ivsorbos)

         Btnsiguiente.setOnClickListener {
             mostrarfrasesAleatoriamente(Tvfrases, Ivsorbos)
         }
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
             val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
             insets


         }


     }

     private fun mostrarfrasesAleatoriamente(Tvfrases: TextView, Ivsorbos: ImageView) {
         // Si ya se han mostrado todas las frases, reiniciar la lista de frases mostradas
         if (frasesMostradas.size == frases.size) {
             Tvfrases.text = "Ha Terminado el juego, ¿en que estado te encuentras?"
             frasesMostradas.clear()
         }

         // Seleccionar una frase aleatoria que no haya sido mostrada aún
         var nuevaFrase: String
         do {
             nuevaFrase = frases[Random.nextInt(frases.size)]
         } while (frasesMostradas.contains(nuevaFrase))

         // Mostrar la frase y agregarla a la lista de frases mostradas
         Tvfrases.text = nuevaFrase
         frasesMostradas.add(nuevaFrase)

         val imagenAleatoria = seleccionarImagenConProbabilidad()
         Ivsorbos.setImageResource(imagenAleatoria)
     }

     private fun seleccionarImagenConProbabilidad(): Int {
         val probabilidad = Random.nextInt(100)
         return when {
             probabilidad < 50 -> image[0] // 40% de probabilidad para imagen 1
             probabilidad < 90 -> image[1] // 40% de probabilidad para imagen 2
             else -> image[2] // 20% de probabilidad para imagen 3
         }
     }
 }