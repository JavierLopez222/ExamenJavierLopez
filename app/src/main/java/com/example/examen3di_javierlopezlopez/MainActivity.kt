package com.example.examen3di_javierlopezlopez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnInsertar = findViewById<Button>(R.id.btnInsertar)
        var btnVisualizar = findViewById<Button>(R.id.btnVisualizar)

        btnInsertar.setOnClickListener{
            var intentIn = Intent(this, Insertar::class.java)
            startActivity(intentIn)
        }

        btnVisualizar.setOnClickListener{
            var intentVi = Intent(this, Visualizar::class.java)
            startActivity(intentVi)
        }
    }
}