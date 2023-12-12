package com.example.examen3di_javierlopezlopez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Visualizar : AppCompatActivity() {
    lateinit var nombretv:TextView
    lateinit var entrenadortv:TextView
    lateinit var tipotv:TextView
    lateinit var estaturatv:TextView
    lateinit var comentariotv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        nombretv = findViewById<TextView>(R.id.nombretv)
        entrenadortv = findViewById<TextView>(R.id.entrenadortv)
        tipotv = findViewById<TextView>(R.id.tipotv)
        estaturatv = findViewById<TextView>(R.id.estaturatv)
        comentariotv = findViewById<TextView>(R.id.comentariotv)



        nombretv.text = nombretv.text.toString()+intent.getStringArrayExtra("nombre")
        entrenadortv.text = entrenadortv.text.toString()+intent.getStringArrayExtra("entrenador")
        tipotv.text = tipotv.text.toString()+intent.getStringArrayExtra("tipo")
        estaturatv.text = estaturatv.text.toString()+intent.getStringArrayExtra("estatura")
        comentariotv.text = comentariotv.text.toString()+intent.getStringArrayExtra("comentario")


        var flechaAtras = findViewById<ImageView>(R.id.flechaAtras)

        flechaAtras.setOnClickListener{
            var intentMenu = Intent(this, MainActivity::class.java)
            startActivity(intentMenu)
        }
    }
}