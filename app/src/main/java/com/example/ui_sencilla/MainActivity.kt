package com.example.ui_sencilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var txtRespuesta : TextView
    private lateinit var textoEditable : EditText
    private lateinit var lista : Array<String>
    private lateinit var texto : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRespuesta = findViewById(R.id.textViewResultado)
        btn = findViewById(R.id.button)
        textoEditable = findViewById(R.id.editTextText)

        btn.setOnClickListener {
            val rango = 1..3
            texto = if (textoEditable.text.isEmpty()) resources.getString(R.string.no_pregunta)
            else{
                when(rango.random()){
                    1 ->{
                        lista = resources.getStringArray(R.array.respuestasBuenas)
                        txtRespuesta.setBackgroundColor(resources.getColor(R.color.colorVerde))
                    }
                    2 ->{
                        lista = resources.getStringArray(R.array.respuestasNeutras)
                        txtRespuesta.setBackgroundColor(resources.getColor(R.color.colorGris))
                    }
                    3 ->{
                        lista = resources.getStringArray(R.array.respuestasMalas)
                        txtRespuesta.setBackgroundColor(resources.getColor(R.color.colorRojo))
                    }
                }
                lista.random()
            }
            txtRespuesta.text = texto
        }
    }
}