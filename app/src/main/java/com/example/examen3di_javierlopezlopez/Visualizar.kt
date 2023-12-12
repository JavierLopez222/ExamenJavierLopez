package com.example.examen3di_javierlopezlopez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Visualizar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        var flechaAtras = findViewById<ImageView>(R.id.flechaAtras)

        flechaAtras.setOnClickListener{
            var intentMenu = Intent(this, MainActivity::class.java)
            startActivity(intentMenu)
        }
    }
}