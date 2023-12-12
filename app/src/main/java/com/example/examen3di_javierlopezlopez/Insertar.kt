package com.example.examen3di_javierlopezlopez

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Insertar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var insertarNombreIL:TextInputLayout
    lateinit var insertarEntrenadorIL:TextInputLayout
    lateinit var insertarTipoIL:TextInputLayout
    lateinit var insertarEstaturaIL: TextInputLayout
    lateinit var insertarComentarioIL: TextInputLayout
    lateinit var insertarFechaIL: TextInputLayout

    lateinit var insertarNombreET:TextInputEditText
    lateinit var insertarEntrenadorET:TextInputEditText
    lateinit var spinner:Spinner
    lateinit var insertarEstaturaET:TextInputEditText
    lateinit var insertarComentarioET:TextInputEditText
    lateinit var insertarFechaET:TextInputEditText
    lateinit var btnInsertar:ImageView

    lateinit var intentMenu:Intent

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

        var flechaAtras = findViewById<ImageView>(R.id.flechaAtras)
        insertarNombreIL = findViewById<TextInputLayout>(R.id.insertarNombreIL)
        insertarEntrenadorIL = findViewById<TextInputLayout>(R.id.insertarEntrenadorIL)
        insertarTipoIL = findViewById<TextInputLayout>(R.id.insertarTipoIL)
        insertarEstaturaIL = findViewById<TextInputLayout>(R.id.insertarEstaturaIL)
        insertarComentarioIL = findViewById<TextInputLayout>(R.id.insertarComentarioIL)
        insertarFechaIL = findViewById<TextInputLayout>(R.id.insertarFechaIL)

        insertarNombreET = findViewById<TextInputEditText>(R.id.insertarNombreET)
        insertarEntrenadorET = findViewById<TextInputEditText>(R.id.insertarEntrenadorET)
        insertarEstaturaET = findViewById<TextInputEditText>(R.id.insertarEstaturaET)
        insertarComentarioET = findViewById<TextInputEditText>(R.id.insertarComentarioET)
        insertarFechaET = findViewById<TextInputEditText>(R.id.insertarFechaET)

        spinner = findViewById<Spinner>(R.id.spinner)
        btnInsertar = findViewById<ImageView>(R.id.btnInsertar)



        val spinner: Spinner = findViewById<Spinner>(R.id.spinner)
        val opciones = arrayOf("Acero", "Agua", "Bicho", "Dragón", "Eléctrico", "Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Planta", " Siniestro")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        flechaAtras.setOnClickListener{
            var intentMenu = Intent(this, MainActivity::class.java)
            startActivity(intentMenu)
        }

        var intentValidar = Intent(this, Visualizar::class.java)

        btnInsertar.setOnClickListener{
            if(validarFormulario()){
                startActivity(intentValidar)
            }
        }

    }
    fun validarFormulario():Boolean{
        var nombre = insertarNombreET.text.toString().trim()
        var entrenador = insertarEntrenadorET.text.toString().trim()
        var estatura = insertarEstaturaET.text.toString().trim()
        var comentario = insertarComentarioET.text.toString().trim()
        var fecha = insertarFechaET.text.toString().trim()


        intentMenu.putExtra(nombre, "nombre")
        intentMenu.putExtra(entrenador, "entrenador")
        intentMenu.putExtra(estatura, "estatura")
        intentMenu.putExtra(comentario, "comentario")



        var validar = true

        if(nombre.isEmpty()){
            insertarNombreET.error = "Este campo no puede estar vacío"
        }
        if(nombre.length<=3){
            insertarNombreET.error = "El nombre debe tener como mínimo 3 carácteres"
            validar = false
        }
        //if(!nombre.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)"))){
        //    insertarNombreET.error = "La primera letra debe ser mayúscula"
        //    validar = false
        //}
        if(entrenador.isEmpty()){
            insertarEntrenadorET.error = "Este campo no puede estar vacío"
        }
        if(entrenador.length>=25){
            insertarEntrenadorET.error = "No puede tener más de 25 carácteres"
            validar = false
        }

        if(estatura.isEmpty()){
            insertarEstaturaET.error = "Este campo no puede estar vacío"
        }
        if(!estatura.isDigitsOnly()){
            insertarEstaturaET.error = "Solo puedes introducir valores enteros"
            validar = false
        }

        return validar

    }
}