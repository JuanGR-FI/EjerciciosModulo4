package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jacgr.ejerciciosmodulo4.R

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)

        val btnElementosGraficos = findViewById<Button>(R.id.btnElementosGraficos)

        btnElementosGraficos.setOnClickListener {
            val intent = Intent(this, SelectionComponentActivity::class.java)
            startActivity(intent)
        }

    }
}